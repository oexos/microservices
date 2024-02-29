package com.service.serviceone.constants;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static List<String> getIstioHeadersToPropagate() {
        List<String> istioHeadersToPropagate = new ArrayList<>();
        istioHeadersToPropagate.add("x-request-id");
        istioHeadersToPropagate.add("x-b3-traceid");
        istioHeadersToPropagate.add("x-b3-spanid");
        istioHeadersToPropagate.add("x-b3-parentspanid");
        istioHeadersToPropagate.add("x-b3-sampled");
        istioHeadersToPropagate.add("x-b3-flags");
        istioHeadersToPropagate.add("x-datadog-trace-id");
        istioHeadersToPropagate.add("x-datadog-parent-id");
        istioHeadersToPropagate.add("x-datadog-sampling-priority");
        istioHeadersToPropagate.add("x-ot-span-context");
        istioHeadersToPropagate.add("grpc-trace-bin");
        istioHeadersToPropagate.add("traceparent");
        istioHeadersToPropagate.add("x-cloud-trace-context");
        istioHeadersToPropagate.add("authorization");
        return istioHeadersToPropagate;
    }
}
