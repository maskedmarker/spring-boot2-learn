package org.example.learn.spring.boot.custom.config.spring.application.controller;

import org.example.learn.spring.boot.commons.model.base.BaseResponseData;
import org.example.learn.spring.boot.commons.model.util.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/echo")
    @ResponseBody
    public BaseResponseData<String> echo(String msg) {
        String echo = String.format("echo %s at %s", msg, Calendar.getInstance().getTime());
        return ResponseUtils.ok(echo);
    }
}
