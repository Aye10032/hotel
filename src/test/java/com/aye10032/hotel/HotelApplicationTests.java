package com.aye10032.hotel;

import com.aye10032.hotel.database.DataInit;
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

}
