package com.carnote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String indexPage(Map<String, Object> map) {

        return "index";
    }
}
