package com.aye10032.hotel.database.pojo;

import java.util.Objects;

/**
 * @program: hotel
 * @className: Room
 * @Description: 房间具体信息实体类
 * @version: v1.0
 * @author: DoubleZhuang
 * @date: 2021/6/8 13:10
 */
public class Room {

    public Integer id;
    public Integer cid;
    public String rno;
    public String status;

    public Room() {
    }

    public Room(Integer id, Integer cid, String rno, String status) {
        this.id = id;
        this.cid = cid;
        this.rno = rno;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) && Objects.equals(cid, room.cid) && Objects.equals(rno, room.rno) && Objects.equals(status, room.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cid, rno, status);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", cid=" + cid +
                ", no='" + rno + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
