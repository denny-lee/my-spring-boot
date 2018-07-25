package com.lee.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author : Liw
 * @description :
 * @date : 2018/4/4 10:41
 */
@Entity
@Table(name = "t_choise")
@DynamicUpdate
public class ChoiseEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer uid;
    private String name;
    private Integer cid;
    private String description;
    private Date createTime;
    private boolean delFlag = false;
    private String remark;

    @Override
    public String toString() {
        return "ChoiseEntity{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", cid=" + cid +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", delFlag=" + delFlag +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isDelFlag() {
        return delFlag;
    }

    public void setDelFlag(boolean delFlag) {
        this.delFlag = delFlag;
    }
}
