package cn.com.wewin.modules.mater.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Li
 * @date 2020/7/28 - 9:40
 */
@RestController
@RequestMapping("/mater")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        return "Hello World";
    }

}
