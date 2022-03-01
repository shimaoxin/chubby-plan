package com.shimaoxin.chubbyplan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author ：shimaoxin
 * @date ：Created in 2022/3/1 10:21
 * @description：
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public Object index(String request) {
        return "Hello Word";
    }
}
