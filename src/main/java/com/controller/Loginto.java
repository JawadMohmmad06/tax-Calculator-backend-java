package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@Controller
public class Loginto {

    @RequestMapping("/defultadmin")
    public String page(HttpServletRequest request) {


System.out.println( request.getRemoteUser());
        return "redirect:http://localhost/taxcalcu/getrate.html";
    }
    @RequestMapping("/defultuser")
    public String pagee(HttpServletRequest request) {


        System.out.println( request.getRemoteUser());
        return "redirect:http://localhost/taxcalcu/calcu.html";
    }
}
