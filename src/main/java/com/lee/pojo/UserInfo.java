package com.lee.pojo;

/**
 * @author : Liw
 * @description :
 * @date : 2018/7/16 13:36
 */
public class UserInfo {
    private Integer times;
    private Integer cid;
    private String description;

    public UserInfo() {
    }

    public UserInfo(Integer times, Integer cid, String description) {
        this.times = times;
        this.cid = cid;
        this.description = description;
    }

    public Integer getTimes() {

        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
