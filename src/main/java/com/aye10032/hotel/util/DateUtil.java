package com.aye10032.hotel.util;

import com.aye10032.hotel.database.pojo.Subscription;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @program: hotel
 * @className: DateUtil
 * @Description: 时间工具类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/6/10 上午 8:47
 */
public class DateUtil {

    public static Date getNowTime() {
        return new Date();
    }

    public static String getDateStr() {
        Date date = getNowTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yy MM dd");
        return formatter.format(date).replace(" ", "");
    }

    public static String getSUB_NO() {
        Subscription subscription = Util.getLastSubscription();
        String date_str = getDateStr();
        if (subscription != null) {
            String last_sno = subscription.getSno();
            if (last_sno.substring(0, 6).equals(date_str)) {
                int last_no = Integer.parseInt(last_sno.substring(6));
                int new_no = last_no + 1;
                return date_str + String.format("%02d",new_no);
            }else {
                return date_str + "01";
            }
        } else {
            return date_str + "01";
        }
    }

}
