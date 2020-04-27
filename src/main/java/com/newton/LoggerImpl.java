package com.newton;

import com.newton.handler.LogHandler;
import com.newton.model.LogLevel;
import com.newton.model.Message;
import lombok.Setter;

public class LoggerImpl implements Logger {

  @Setter
  LogHandler logHandler;

  public void debug(String message) throws Exception {
    log(message, LogLevel.DEBUG);
  }

  public void info(String message) throws Exception {
    log(message, LogLevel.INFO);
  }

  public void warn(String message) throws Exception {
    log(message, LogLevel.WARN);
  }

  public void error(String message) throws Exception {
    log(message, LogLevel.ERROR);
  }

  public void fatal(String message) throws Exception {
    log(message, LogLevel.FATAL);
  }

  private void log(String message, LogLevel level) throws Exception {
    logHandler.log(createMessage(message, level));
  }

  private Message createMessage(String message, LogLevel level) {
    return Message.builder().message(message).level(level).build();
  }
}
