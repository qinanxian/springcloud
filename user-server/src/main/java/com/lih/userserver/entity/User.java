package com.lih.userserver.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="user")
public class User implements Serializable,Cloneable {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证
     */
    private String cardid;
    /**
     * 住址
     */
    private String address;
    /**
     * 出生日期
     */
    private String birth;

    /**
     * id
     */
    public String getId() {
        return this.id;
    }

    /**
     * id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 姓名
     */
    public String getName() {
        return this.name;
    }

    /**
     * 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 身份证
     */
    public String getCardid() {
        return this.cardid;
    }

    /**
     * 身份证
     */
    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    /**
     * 住址
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 住址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 出生日期
     */
    public String getBirth() {
        return this.birth;
    }

    /**
     * 出生日期
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }
}
