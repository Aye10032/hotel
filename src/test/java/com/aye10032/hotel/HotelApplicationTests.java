package com.aye10032.hotel;

import com.aye10032.hotel.database.DataInit;
import com.aye10032.hotel.util.DateUtil;
import com.aye10032.hotel.util.Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testData(){
        DataInit.init();
    }

    @Test
    void testGetID(){
//        System.out.println(Util.getMemberID("Aye10032"));
        System.out.println(Util.getLastSubscription());
    }


    @Test
    void testDate(){
//        String date_str = DateUtil.getDateStr();
//        System.out.println(date_str);
//        date_str = date_str + "01";
//        System.out.println(date_str);
//        System.out.println(date_str.substring(0,6));
//        System.out.println(date_str.substring(6));

        System.out.println(DateUtil.getSUB_NO());
    }

}
