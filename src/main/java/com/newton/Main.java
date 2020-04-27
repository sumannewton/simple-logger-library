package com.newton;

import com.newton.config.Config;
import com.newton.config.LogConfig;
import com.newton.config.SinkConfig;
import com.newton.model.LogLevel;
import com.newton.model.LoggerType;
import com.newton.model.SinkType;

public class Main {

  public static void main(String[] args) throws Exception {


    //Initialize
    Config config = Config.builder()
        .logConfig(LogConfig.builder()
            .loggerType(LoggerType.ASYNC)
            .ts_format("dd-mm-yyyy-hh-mm-ss")
            .bufferSize(25)
            .build())
        .sinkConfig(SinkConfig.builder()
            .level(LogLevel.FATAL)
            .sinkType(SinkType.STDOUT)
            .build())
        .build();
    Logger logger = LogManager.getLogger(config);

    // Usage
    logger.warn("1This is a sample warn.");
    logger.debug("2This is a sample debug");
    logger.error("3This is a sample error.");
    logger.fatal("4This is a sample fatal.");
    logger.info("5This is a sample info.");
    logger.warn("6This is a sample warn.");
    logger.warn("7This is a sample warn.");
    logger.debug("8This is a sample debug");
    logger.error("9This is a sample error.");
    logger.fatal("10This is a sample fatal.");
    logger.info("11This is a sample info.");
    logger.warn("12This is a sample warn.");
//    Thread.sleep(5);
  }
}
