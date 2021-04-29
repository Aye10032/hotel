package com.aye10032.hotel.database.pojo;

import java.util.Date;
import java.util.Objects;

/**
 * @program: hotel
 * @className: Member
 * @Description: 会员信息实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 10:56
 */
public class Member {

    public Integer id;
    public String username;
    public String pwd;
    public String name;
    public String email;
    public String phone;
    public Date regtime;

    public Member() {
    }

    public Member(Integer id, String username, String pwd, String name, String email, String phone, Date regtime) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.regtime = regtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(username, member.username) && Objects.equals(pwd, member.pwd) && Objects.equals(name, member.name) && Objects.equals(email, member.email) && Objects.equals(phone, member.phone) && Objects.equals(regtime, member.regtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, pwd, name, email, phone, regtime);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", regtime=" + regtime +
                '}';
    }
}
