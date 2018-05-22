package com.lee.config;

import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingjdbc.core.api.config.strategy.NoneShardingStrategyConfiguration;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Liw
 * @description :
 * @date : 2018/5/21 13:33
 */
@Configuration
public class ShardingDbConfig {

    @Bean
    public DataSource dataSource() throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        // To configure the first data source
        BasicDataSource dataSource1 = new BasicDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://tbbmysqldev.ops.com:3306/demo_ds_0?useUnicode=true&characterEncoding=utf-8");
        dataSource1.setUsername("root");
        dataSource1.setPassword("mysql_test");
        /*dataSource1.setInitialSize(1);
        dataSource1.setMinIdle(1);
        dataSource1.setValidationQuery("SELECT 1");
        dataSource1.setTestWhileIdle(true);
        dataSource1.setMaxWait(60000);*/
        dataSourceMap.put("ds_0", dataSource1);


        // To configure the second data source
        BasicDataSource dataSource2 = new BasicDataSource();
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setUrl("jdbc:mysql://tbbmysqldev.ops.com:3306/demo_ds_1?useUnicode=true&characterEncoding=utf-8");
        dataSource2.setUsername("root");
        dataSource2.setPassword("mysql_test");
        /*dataSource2.setInitialSize(1);
        dataSource2.setMinIdle(1);
        dataSource2.setValidationQuery("SELECT 1");
        dataSource2.setTestWhileIdle(true);
        dataSource2.setMaxWait(60000);*/

        dataSourceMap.put("ds_1", dataSource2);

        // To configure the table rules for Order
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        orderTableRuleConfig.setLogicTable("t_order");
        orderTableRuleConfig.setActualDataNodes("ds_${0..1}.t_order_${0..1}");

        // To configure the strategy for database Sharding.
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds_${user_id % 2}"));

        // To configure the strategy for table Sharding.
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_${order_id % 2}"));

        // To configure the strategy rule of Sharding
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);

        // To configure the table rules for order_item
        TableRuleConfiguration orderTableRuleConfig1 = new TableRuleConfiguration();
        orderTableRuleConfig1.setLogicTable("boyfriend");
        orderTableRuleConfig1.setActualDataNodes("ds_0.boyfriend");
        orderTableRuleConfig1.setDatabaseShardingStrategyConfig(new NoneShardingStrategyConfiguration());
        orderTableRuleConfig1.setTableShardingStrategyConfig(new NoneShardingStrategyConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig1);
        TableRuleConfiguration orderTableRuleConfig2 = new TableRuleConfiguration();
        orderTableRuleConfig2.setLogicTable("girl");
        orderTableRuleConfig2.setActualDataNodes("ds_1.girl");
        orderTableRuleConfig2.setDatabaseShardingStrategyConfig(new NoneShardingStrategyConfiguration());
        orderTableRuleConfig2.setTableShardingStrategyConfig(new NoneShardingStrategyConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig2);



        Properties jpaProperties = new Properties();
        jpaProperties.put("sql.show", true);

        // To get the data source object
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentHashMap(), jpaProperties);
        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws SQLException {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.lee.entity");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }
}
