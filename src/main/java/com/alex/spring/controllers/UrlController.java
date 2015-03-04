package com.alex.spring.controllers;

import com.alex.spring.model.User;
import com.alex.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by alex on 2/25/2015.
 */

@Slf4j
@Controller
public class UrlController {

    /*@RequestMapping("/index")
    public String loadingPages() {
        log.info("load index page");

        return "index";
    }*/

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public ModelAndView handleRequestInternal(/*HttpServletRequest request,
                                              HttpServletResponse response*/) throws Exception {
        log.info("load index page");
        ModelAndView model = new ModelAndView("index");
        model.addObject("user1", userService.fingAll().get(0));
        model.addObject("user2", userService.fingAll().get(1));

        return model;
    }


}