package org.example.learn.spring.boot.hello.controller;

import org.example.learn.spring.boot.hello.model.dto.BaseResponseData;
import org.example.learn.spring.boot.hello.util.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/echo")
    @ResponseBody
    public BaseResponseData<String> echo(String msg, HttpServletRequest request, HttpServletResponse response) {
        String echo = String.format("echo %s at %s", msg, Calendar.getInstance().getTime());
        return ResponseUtils.ok(echo);
    }
}
