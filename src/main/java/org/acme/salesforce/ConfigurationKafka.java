package org.acme.salesforce;

import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.component.kafka.KafkaConfiguration;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
public class ConfigurationKafka {

    @ConfigProperty(name = "kafka.brokers")
    String brokers;

    @ConfigProperty(name = "kafka.clientId")
    String clientId;

    @Named("kafka")
    KafkaComponent kafkaComponent() {
        KafkaConfiguration kafkaConfiguration = new KafkaConfiguration();
        kafkaConfiguration.setClientId(clientId);
        kafkaConfiguration.setBrokers(brokers);
        KafkaComponent component = new KafkaComponent();
        component.setConfiguration(kafkaConfiguration);
        return component;
    }
}
