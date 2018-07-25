package com.lee.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private Integer id;
    private String description;

    public OptionEntity() {
    }

    public OptionEntity(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
