package com.newton.sink;

import com.newton.config.SinkConfig;
import com.newton.model.Message;

public class StdOutSink extends AbstractSink {

  public StdOutSink(SinkConfig sinkConfig) {
    super(sinkConfig);
  }

  @Override
  protected void initSink() {

  }

  public void sink(Message message) {
    System.out.println(String.format("%s [%s] %s", message.getTimestamp(), message.getLevel(), message.getMessage()));
  }
}
