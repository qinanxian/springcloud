package com.lih.userserver.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="user")

public class User implements Serializable,Cloneable{
    /** id */
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;
    /** 姓名 */
    private String name;
    /** 身份证 */
    private String cardid;
    /** 手机号 */
    private String phone;
    /** 住址 */
    private String address;
    /** 出生日期 */
    private String birth;
    /** 登录密码 */
    private String accountPassword;
    /** 登录账号 */
    private String accountNumber;

    /** id */
    public String getId(){
        return this.id;
    }
    /** id */
    public void setId(String id){
        this.id = id;
    }
    /** 姓名 */
    public String getName(){
        return this.name;
    }
    /** 姓名 */
    public void setName(String name){
        this.name = name;
    }
    /** 身份证 */
    public String getCardid(){
        return this.cardid;
    }
    /** 身份证 */
    public void setCardid(String cardid){
        this.cardid = cardid;
    }
    /** 手机号 */
    public String getPhone(){
        return this.phone;
    }
    /** 手机号 */
    public void setPhone(String phone){
        this.phone = phone;
    }
    /** 住址 */
    public String getAddress(){
        return this.address;
    }
    /** 住址 */
    public void setAddress(String address){
        this.address = address;
    }
    /** 出生日期 */
    public String getBirth(){
        return this.birth;
    }
    /** 出生日期 */
    public void setBirth(String birth){
        this.birth = birth;
    }
    /** 登录密码 */
    public String getAccountPassword(){
        return this.accountPassword;
    }
    /** 登录密码 */
    public void setAccountPassword(String accountPassword){
        this.accountPassword = accountPassword;
    }
    /** 登录账号 */
    public String getAccountNumber(){
        return this.accountNumber;
    }
    /** 登录账号 */
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
}
