# sprouts-logstash-appender-spring-boot-starter

## Description
Logstash appender가 포함 된 spring boot starter입니다.

## Configuration
```xml
<!-- pom.xml -->
<dependencies>
    <dependency>
        <groupId>kr.sprouts.autoconfigure</groupId>
        <artifactId>sprouts-logstash-appender-spring-boot-starter</artifactId>
        <version>0.0.1</version>
    </dependency>
</dependencies>
```
```yml
# application.yml
sprouts:
  logstash-appender:
    name: appender_name
    identifier: identifier
    destinations:
      - host: 127.0.0.1
        port: 5045
      - host: 192.168.0.2
        port: 5045
```

## Related dependencies
> * [log4j](https://logging.apache.org/log4j/2.x/)
> * [logback](https://logback.qos.ch/)
> * [logstash-logback-encoder](https://github.com/logfellow/logstash-logback-encoder)
