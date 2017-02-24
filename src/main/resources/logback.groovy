import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.classic.encoder.PatternLayoutEncoder

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO

appender("ROLLING", RollingFileAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{5} Groovy - %msg%n"
  }
  rollingPolicy(TimeBasedRollingPolicy){
    FileNamePattern = "vetlog-spring-boot-%d{yyyy-MM}.log"
  }
}

logger("com.jos.dem.vetlog", INFO)
logger('org.springframework', WARN)
root(WARN, ["ROLLING"])