package com.newton.sink;

import com.newton.config.SinkConfig;
import com.newton.model.Message;

public class FileSink extends AbstractSink {

  public FileSink(SinkConfig sinkConfig) {
    super(sinkConfig);
  }

  @Override
  protected void initSink() {

  }

  @Override
  protected void sink(Message message) {
    // TODO: To be implemented.
  }
}
