package com.lih.articleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Action;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ArticeleController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public void articeleTest(){
        String forObject = restTemplate.getForObject("http://USER-SERVER/api/user", String.class);
        System.out.println(forObject);
        
    }
}
