package com.polyglot.mobile.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rajiv Singla on 10/20/2015.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/welcome")
    public
    @ResponseBody
    String helloWorld() {
        return "Hello World";
    }

}
