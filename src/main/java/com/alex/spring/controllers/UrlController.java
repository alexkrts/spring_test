package com.alex.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alex on 2/25/2015.
 */

@Slf4j
@Controller
public class UrlController {

    @RequestMapping("/index")
    public String loadingPages() {
        log.info("load index page");
        return "index";
    }

}