package com.service.serviceone.controllers;

import com.service.serviceone.httpclient.ServiceTwoFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("one")
@Slf4j
public class ServiceOneController {
    @Autowired
    private ServiceTwoFeign serviceTwoFeign;


    @GetMapping
    public String getOne(@RequestHeader Map<String, String> headers, @RequestParam Map<String, String> params) {
        String response = "Response from GET /service-one/one \n" +
                "Feign response after calling GET /service-two/two: " + serviceTwoFeign.getTwo()
                + "\n All service-one headers received: " + headers.toString() + "\n All query params: " + params;
        log.info(response);
        return response;
    }
}
