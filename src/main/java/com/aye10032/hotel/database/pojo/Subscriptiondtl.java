package com.aye10032.hotel.database.pojo;

import java.util.Date;
import java.util.Objects;

/**
 * @program: hotel
 * @className: Subscriptiondtl
 * @Description: 订单详细信息实体类
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/6/8 13:40
 */
public class Subscriptiondtl {
    public Integer id;
    public Integer rid;
    public Integer sid;
    public Date sdate;
    public Date edate;
    public String residetype;
    public String price;

    public Subscriptiondtl() {
    }

    public Subscriptiondtl(Integer id, Integer rid, Integer sid, Date sdate, Date edate, String residetype, String price) {
        this.id = id;
        this.rid = rid;
        this.sid = sid;
        this.sdate = sdate;
        this.edate = edate;
        this.residetype = residetype;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public String getResidetype() {
        return residetype;
    }

    public void setResidetype(String residetype) {
        this.residetype = residetype;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriptiondtl that = (Subscriptiondtl) o;
        return Objects.equals(id, that.id) && Objects.equals(rid, that.rid) && Objects.equals(sid, that.sid) && Objects.equals(sdate, that.sdate) && Objects.equals(edate, that.edate) && Objects.equals(residetype, that.residetype) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rid, sid, sdate, edate, residetype, price);
    }

    @Override
    public String toString() {
        return "Subscriptiondtl{" +
                "id=" + id +
                ", rid=" + rid +
                ", sid=" + sid +
                ", sdate=" + sdate +
                ", edate=" + edate +
                ", residetype='" + residetype + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
