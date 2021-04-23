package com.doublezhuang.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: hotel
 * @className: IndexController
 * @Description: index界面controller
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/23 上午 10:03
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
