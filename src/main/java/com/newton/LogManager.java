package com.newton;

import com.newton.config.Config;
import com.newton.handler.AsyncLogHandler;
import com.newton.handler.SyncLogHandler;
import com.newton.model.LoggerType;
import com.newton.sink.ISink;
import com.newton.sink.StdOutSink;

public class LogManager {

  private LogManager() {}

  volatile static Logger logger;

  public static Logger getLogger(Config config) throws Exception {
    if (logger == null) {
      logger = initLogger(config);
    }
    return logger;
  }

  private static Logger initLogger(Config config) throws Exception {
    logger = new LoggerImpl();
    ISink sink = initSink(config);
    if (config.getLogConfig().getLoggerType().equals(LoggerType.ASYNC)) {
      ((LoggerImpl)logger).setLogHandler(new AsyncLogHandler(sink, config.getLogConfig()));
    } else {
      ((LoggerImpl)logger).setLogHandler(new SyncLogHandler(sink));
    }
    return logger;
  }

  private static ISink initSink(Config config) throws Exception {
    ISink sink = null;
    switch (config.getSinkConfig().getSinkType()) {
      case STDOUT:
        sink = new StdOutSink(config.getSinkConfig());
        break;
      default:
        throw new Exception("Invalid Sink Type.");

        // case "FILE":
    }
    return sink;
  }
}
