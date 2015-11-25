package com.thinking.moduleb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/module/B")
public class ModuleBController {
    @RequestMapping("/ajax")
    public String ajaxRequest() {
        return "";
    }
}
