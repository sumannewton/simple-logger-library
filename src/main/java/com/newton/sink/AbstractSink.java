package com.newton.sink;

import com.newton.config.SinkConfig;
import com.newton.model.LogLevel;
import com.newton.model.Message;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractSink implements ISink {

  public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
  private LogLevel level;
  protected SinkConfig sinkConfig;

  public AbstractSink(SinkConfig sinkConfig) {
    this.sinkConfig = sinkConfig;
  }

  public void init() {
    this.level = sinkConfig.getLevel();
    initSink();
  }

  public void publish(Message message) {
    if (message.getLevel().ordinal() >= level.ordinal()) {
      message.setTimestamp(DATE_FORMAT.format(new Date(System.currentTimeMillis())));
      sink(message);
    }
  }

  protected abstract void initSink();
  protected abstract void sink(Message message);
}
