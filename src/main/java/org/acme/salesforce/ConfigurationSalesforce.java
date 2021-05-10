package org.acme.salesforce;

import org.apache.camel.component.salesforce.AuthenticationType;
import org.apache.camel.component.salesforce.SalesforceComponent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
public class ConfigurationSalesforce {

    @ConfigProperty(name = "salesforce.loginUrl")
    String loginUrl;

    @ConfigProperty(name = "salesforce.clientId")
    String clientId;

    @ConfigProperty(name = "salesforce.clientSecret")
    String clientSecret;

    @ConfigProperty(name = "salesforce.userName")
    String userName;

    @ConfigProperty(name = "salesforce.password")
    String password;

    @Named("salesforce")
    SalesforceComponent salesforceComponent() {
        SalesforceComponent component = new SalesforceComponent();
        component.setLoginUrl(loginUrl);
        component.setClientId(clientId);
        component.setClientSecret(clientSecret);
        component.setUserName(userName);
        component.setPassword(password);
        component.setAuthenticationType(AuthenticationType.USERNAME_PASSWORD);
        return component;
    }
}
