package org.acme.salesforce;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

import java.util.Map;

public class CdcRoute extends EndpointRouteBuilder {

    @Override
    public void configure() throws Exception {

        from(salesforce("data/ChangeEvents").replayId(-1L))
                .process(exchange -> {
                    Map headers = exchange.getIn().getHeaders();
                    Map body = exchange.getIn().getBody(Map.class);
                    body.putAll(headers);
                })
                .setHeader("topic", simple("${header.CamelSalesforceEntityName.toLowerCase()}"))
                .toD(kafka("${header.topic}"));
    }
}
