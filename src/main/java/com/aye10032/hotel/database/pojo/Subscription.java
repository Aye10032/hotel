package com.aye10032.hotel.database.pojo;

import java.sql.Date;

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
    public String no;
    public String linkman;
    public String email;
    public String phone;
    public String status;
    public Date cretime;
    public String remark;
}
