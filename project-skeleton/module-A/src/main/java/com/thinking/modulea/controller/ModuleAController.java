package com.thinking.modulea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/module/A")
public class ModuleAController {

    @RequestMapping("/ajax")
    public String ajaxRequest() {
        return "";
    }
}
