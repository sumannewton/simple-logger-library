package com.newton.handler;

import com.newton.model.Message;
import com.newton.sink.ISink;

public class SyncLogHandler extends LogHandler {

  public SyncLogHandler(ISink sink) {
    super(sink);
  }

  @Override
  public void log(Message message) {
    sink.publish(message);
  }
}
