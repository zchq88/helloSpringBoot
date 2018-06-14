package com.zchq88.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Hello {
    @RequestMapping(value = "/hello")
    public String hello() {
        log.warn("test");
        return "Hello zchq88";
    }
}
