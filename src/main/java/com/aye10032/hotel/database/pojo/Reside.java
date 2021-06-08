package com.aye10032.hotel.database.pojo;

import java.util.Objects;

/**
 * @program: hotel
 * @className: Reside
 * @Description: 详细订单信息实体类
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/6/8 13:08
 */
public class Reside {
    public Integer id;
    public String dtlid;
    public String residedate;
    public String roomname;
    public String idcard;

    public Reside() {
    }

    public Reside(Integer id, String dtlid, String residedate, String roomname, String idcard) {
        this.id = id;
        this.dtlid = dtlid;
        this.residedate = residedate;
        this.roomname = roomname;
        this.idcard = idcard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDtlid() {
        return dtlid;
    }

    public void setDtlid(String dtlid) {
        this.dtlid = dtlid;
    }

    public String getResidedate() {
        return residedate;
    }

    public void setResidedate(String residedate) {
        this.residedate = residedate;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reside reside = (Reside) o;
        return Objects.equals(id, reside.id) && Objects.equals(dtlid, reside.dtlid) && Objects.equals(residedate, reside.residedate) && Objects.equals(roomname, reside.roomname) && Objects.equals(idcard, reside.idcard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dtlid, residedate, roomname, idcard);
    }

    @Override
    public String toString() {
        return "Reside{" +
                "id=" + id +
                ", dtlid='" + dtlid + '\'' +
                ", residedate='" + residedate + '\'' +
                ", roomname='" + roomname + '\'' +
                ", idcard='" + idcard + '\'' +
                '}';
    }
}
