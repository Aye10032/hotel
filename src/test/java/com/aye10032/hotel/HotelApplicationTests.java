package com.aye10032.hotel;

import com.aye10032.hotel.database.DataInit;
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
        System.out.println(Util.getMemberID("Aye10032"));
    }

}
