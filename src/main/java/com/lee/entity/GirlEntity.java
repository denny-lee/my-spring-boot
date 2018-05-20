package com.lee.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

/**
 * @author : Liw
 * @description :
 * @date : 2018/4/4 10:41
 */
@Entity
@Table(name = "girl")
@DynamicUpdate
public class GirlEntity {

    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String nickName;

    @OneToMany(mappedBy = "myGirl", fetch = FetchType.EAGER)
    private Set<BoyFriendEntity> boyFriends;

    public Set<BoyFriendEntity> getBoyFriends() {
        return boyFriends;
    }

    public void setBoyFriends(Set<BoyFriendEntity> boyFriends) {
        this.boyFriends = boyFriends;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "GirlEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                ", boyFriends=" + boyFriends +
                '}';
    }
}
