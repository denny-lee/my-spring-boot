package com.lee.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lee.config.DateJsonDeserializer;

import java.util.Date;

/**
 * @author : Liw
 * @description :
 * @date : 2018/3/9 17:14
 */
public class Bread {
    @JsonDeserialize(using=DateJsonDeserializer.class)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
