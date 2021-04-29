package com.aye10032.hotel.database.pojo;

import java.util.Objects;

/**
 * @program: hotel
 * @className: Manager
 * @Description: 管理员信息实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 10:54
 */
public class Manager {

    public Integer id;
    public String username;
    public String pwd;

    public Manager() {
    }

    public Manager(Integer id, String username, String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(id, manager.id) && Objects.equals(username, manager.username) && Objects.equals(pwd, manager.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, pwd);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
