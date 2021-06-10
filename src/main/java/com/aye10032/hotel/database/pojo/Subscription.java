package com.aye10032.hotel.database.pojo;

import java.util.Date;
import java.util.Objects;

/**
 * @program: hotel
 * @className: Subscription
 * @Description: 订单相关实体类
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/6/8 13:21
 */
public class Subscription {
    public Integer id;
    public Integer mid;
    public String sno;
    public String linkman;
    public String email;
    public String phone;
    public String status;
    public Date cretime;
    public String remark;

    public Subscription() {
    }

    public Subscription(Integer id, Integer mid, String sno, String linkman, String email, String phone, String status, Date cretime, String remark) {
        this.id = id;
        this.mid = mid;
        this.sno = sno;
        this.linkman = linkman;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.cretime = cretime;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCretime() {
        return cretime;
    }

    public void setCretime(Date cretime) {
        this.cretime = cretime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(id, that.id) && Objects.equals(mid, that.mid) && Objects.equals(sno, that.sno) && Objects.equals(linkman, that.linkman) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(status, that.status) && Objects.equals(cretime, that.cretime) && Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mid, sno, linkman, email, phone, status, cretime, remark);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", mid=" + mid +
                ", no='" + sno + '\'' +
                ", linkman='" + linkman + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", cretime=" + cretime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
