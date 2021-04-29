package com.aye10032.hotel;

import com.aye10032.hotel.database.DataInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelApplication {

    public static void main(String[] args) {
        DataInit.init();
        SpringApplication.run(HotelApplication.class, args);
    }

}
