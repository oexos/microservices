package com.service.serviceone.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-two", url = "${service-two-url}")
public interface ServiceTwoFeign {
    @GetMapping("two")
    String getTwo();
}
