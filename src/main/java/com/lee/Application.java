package com.lee;

import com.lee.model.Girl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
@EnableCaching
@RestController
public class Application {

	@PostMapping("/home")
	public Object tets(@RequestBody Girl girl) {
		System.out.println(girl.getAge());
		return girl;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Bean
	public ErrorPageRegistrar errorPageRegistrar(){
		return new MyErrorPageRegistrar();
	}

	private static class MyErrorPageRegistrar implements ErrorPageRegistrar {

		@Override
		public void registerErrorPages(ErrorPageRegistry registry) {
			registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
		}

	}*/
}
