package com.lee.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : Liw
 * @description :
 * @date : 2018/4/4 10:41
 */
@Entity
@Table(name = "t_option")
@DynamicUpdate
public class OptionEntity {

    @Id
    private Integer id;
    private String desc;

    @Override
    public String toString() {
        return "OptionEntity{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
