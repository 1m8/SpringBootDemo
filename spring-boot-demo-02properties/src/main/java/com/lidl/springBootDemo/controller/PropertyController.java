package com.lidl.springBootDemo.controller;

import com.lidl.springBootDemo.property.ApplicationProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PropertyController {

    @Autowired
    private ApplicationProperty applicationProperty;

    @GetMapping("/property")
    public String  test(){
        return  applicationProperty.toString();
    }
}
