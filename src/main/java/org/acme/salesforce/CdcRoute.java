package org.acme.salesforce;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

public class CdcRoute extends EndpointRouteBuilder {

    @Override
    public void configure() throws Exception {

        from(salesforce("data/ChangeEvents").replayId(-1L))
                .setHeader("topic", simple("${header.CamelSalesforceEntityName.toLowerCase()}"))
                .toD(kafka("${header.topic}"));
    }
}
