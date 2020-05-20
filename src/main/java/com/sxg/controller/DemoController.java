package com.sxg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Thymeleaf 入门案例
 */
@Controller
public class DemoController {

    @RequestMapping("/show")
    public String showInfo(Model model){
        model.addAttribute("msg","11111");
        return "index";
    }
}
