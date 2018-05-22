package com.lee.entity;

import javax.persistence.*;

@Entity
@Table(name = "boyfriend")
public class BoyFriendEntity {

    @Id
    private Integer id;
    private int age;
    private String name;
    private Integer girlId;

//    @ManyToOne(targetEntity = GirlEntity.class)
//    @JoinColumn(name = "girlId", referencedColumnName = "id", insertable = false, updatable = false)
//    private GirlEntity myGirl;

//    public GirlEntity getMyGirl() {
//        return myGirl;
//    }

//    public void setMyGirl(GirlEntity myGirl) {
//        this.myGirl = myGirl;
//    }

    public Integer getGirlId() {
        return girlId;
    }

    public void setGirlId(Integer girlId) {
        this.girlId = girlId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BoyFriendEntity{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", girlId=" + girlId +
                '}';
    }
}
