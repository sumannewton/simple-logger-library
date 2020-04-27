package com.newton.handler;

import com.newton.model.Message;
import com.newton.sink.ISink;

public abstract class LogHandler {

  ISink sink;

  protected LogHandler(ISink sink) {
    this.sink = sink;
    sink.init();
  }

  public abstract void log(Message message) throws Exception;

//  public void logAllSink(Message message) {
//    sinks.parallelStream().forEach(iSink -> iSink.publish(message));
//  }
}
