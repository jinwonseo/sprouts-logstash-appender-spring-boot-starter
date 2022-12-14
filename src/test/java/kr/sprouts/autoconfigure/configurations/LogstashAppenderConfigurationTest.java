package kr.sprouts.autoconfigure.configurations;

import kr.sprouts.autoconfigure.properties.LogstashAppenderProperty;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LogstashAppenderConfigurationTest {
    private final ApplicationContextRunner applicationContextRunner
            = new ApplicationContextRunner().withConfiguration(AutoConfigurations.of(LogstashAppenderConfiguration.class));

    private static String[] properties;

    @BeforeAll
    public static void setAllProperties() {
        List<String> logstashAppenderProperties = new ArrayList<>();
        logstashAppenderProperties.add("sprouts.logstash-appender.name=appender_name");
        logstashAppenderProperties.add("sprouts.logstash-appender.identifier=appender_identifier");
        logstashAppenderProperties.add("sprouts.logstash-appender.destinations[0].host=127.0.0.1");
        logstashAppenderProperties.add("sprouts.logstash-appender.destinations[0].port=5045");
        logstashAppenderProperties.add("sprouts.logstash-appender.destinations[1].host=192.168.0.2");
        logstashAppenderProperties.add("sprouts.logstash-appender.destinations[1].port=5045");

        properties = logstashAppenderProperties.toArray(String[]::new);
    }

    @Test
    public void bean_test() {
        this.applicationContextRunner.withPropertyValues(properties).run(
                context -> assertThat(context).hasSingleBean(LogstashAppenderConfiguration.class)
        );
    }

    @Test
    public void property_binding_test() {
        this.applicationContextRunner.withPropertyValues(properties).run(
            context -> {
                assertThat(context.getBean(LogstashAppenderProperty.class).getName()).isEqualTo("appender_name");
                assertThat(context.getBean(LogstashAppenderProperty.class).getIdentifier()).isEqualTo("appender_identifier");
                assertThat(context.getBean(LogstashAppenderProperty.class).getDestinations().stream().map(
                        destination -> new InetSocketAddress(destination.getHost(), destination.getPort())
                ).collect(Collectors.toList())).contains(new InetSocketAddress("127.0.0.1", 5045));
                assertThat(context.getBean(LogstashAppenderProperty.class).getDestinations().stream().map(
                        destination -> new InetSocketAddress(destination.getHost(), destination.getPort())
                ).collect(Collectors.toList())).contains(new InetSocketAddress("192.168.0.2", 5045));
            }
        );
    }
}