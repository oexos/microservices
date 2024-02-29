package com.service.servicetwo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("two")
@Slf4j
public class ServiceTwoController {
    @GetMapping
    public String getOne(@RequestHeader Map<String, String> headers) {
        String response = "Response from GET /service-two/two at " + new Date() + "\n" + "All headers: " + headers;
        log.info(response);
        return response;
    }
}
