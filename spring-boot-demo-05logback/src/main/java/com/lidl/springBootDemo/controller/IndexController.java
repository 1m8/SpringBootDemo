package com.lidl.springBootDemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {

    @GetMapping("/test")
    public String test(){

        log.error("ss");

        return "test";
    }
}
