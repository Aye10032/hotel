package com.aye10032.hotel.database.pojo;

import java.util.Date;
import java.util.Objects;

/**
 * @program: hotel
 * @className: SubdtlTemp
 * @Description: 用于显示订单详情界面的实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/13 下午 2:48
 */
public class SubdtlTemp {

    /*
    * <th>房间类型</th>
                    <th>房间号</th>
                    <th>预定方式</th>
                    <th>单价</th>
                    <th>入住日期</th>
                    <th>退房日期</th>
                    <th>操作</th>*/

    public Integer id;
    public String r_type;
    public String rno;
    public String res_type;
    public Float price;
    public  Date Sdate;
    public  Date Edate;

    public SubdtlTemp() {
    }

    public SubdtlTemp(Integer id, String r_type, String rno, String res_type, Float price, Date sdate, Date edate) {
        this.id = id;
        this.r_type = r_type;
        this.rno = rno;
        this.res_type = res_type;
        this.price = price;
        Sdate = sdate;
        Edate = edate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getR_type() {
        return r_type;
    }

    public void setR_type(String r_type) {
        this.r_type = r_type;
    }

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getRes_type() {
        return res_type;
    }

    public void setRes_type(String res_type) {
        this.res_type = res_type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getSdate() {
        return Sdate;
    }

    public void setSdate(Date sdate) {
        Sdate = sdate;
    }

    public Date getEdate() {
        return Edate;
    }

    public void setEdate(Date edate) {
        Edate = edate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubdtlTemp that = (SubdtlTemp) o;
        return Objects.equals(id, that.id) && Objects.equals(r_type, that.r_type) && Objects.equals(rno, that.rno) && Objects.equals(res_type, that.res_type) && Objects.equals(price, that.price) && Objects.equals(Sdate, that.Sdate) && Objects.equals(Edate, that.Edate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, r_type, rno, res_type, price, Sdate, Edate);
    }

    @Override
    public String toString() {
        return "SubdtlTemp{" +
                "id=" + id +
                ", r_type='" + r_type + '\'' +
                ", rno='" + rno + '\'' +
                ", res_type='" + res_type + '\'' +
                ", price=" + price +
                ", Sdate=" + Sdate +
                ", Edate=" + Edate +
                '}';
    }
}
