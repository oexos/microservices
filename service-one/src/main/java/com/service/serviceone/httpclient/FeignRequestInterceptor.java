package com.service.serviceone.httpclient;

import com.service.serviceone.constants.Constants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
            List<String> istioHeadersToPropagate = Constants.getIstioHeadersToPropagate();
            httpServletRequest.getHeaderNames().asIterator()
                    .forEachRemaining(header -> {
                        if (istioHeadersToPropagate.contains(header)) {
                            template.header(header, httpServletRequest.getHeader(header));
                        }
                    });
        }
    }
}
