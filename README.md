# sprouts-logstash-appender-spring-boot-starter

## Description

Spring boot starter with Logstash appender.

## Configurations

* maven
  ```xml
  <dependencies>
    <dependency>
      <groupId>kr.sprouts.autoconfigure</groupId>
      <artifactId>sprouts-logstash-appender-spring-boot-starter</artifactId>
      <version>0.0.2</version>
    </dependency>
  </dependencies>
  ```

* gradle
  ```groovy
  dependencies {
    implementation 'kr.sprouts.autoconfigure:sprouts-logstash-appender-spring-boot-starter:0.0.2'
  }
  ```
* application.yml
  ```yml
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
* [log4j](https://logging.apache.org/log4j/2.x/)
* [logback](https://logback.qos.ch/)
* [logstash-logback-encoder](https://github.com/logfellow/logstash-logback-encoder)
