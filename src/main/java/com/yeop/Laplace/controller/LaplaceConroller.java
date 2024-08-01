package com.yeop.Laplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LaplaceConroller {
    @GetMapping("/")
    @ResponseBody
    public String main() {
        return "화이팅!";
    }
}
