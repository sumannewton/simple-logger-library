package com.newton.handler;

import com.newton.config.LogConfig;
import com.newton.model.Message;
import com.newton.sink.ISink;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class AsyncLogHandler extends LogHandler {

  public static final int BUFFER_SIZE = 5;
  LinkedBlockingQueue<Message> buffer;

  public AsyncLogHandler(ISink sink, LogConfig asyncLogConfig) {
    super(sink);
    int bufferSize = asyncLogConfig.getBufferSize() == 0 ? BUFFER_SIZE : asyncLogConfig.getBufferSize();
    this.buffer = new LinkedBlockingQueue<>(bufferSize);
    Future<Object> task = Executors.newSingleThreadExecutor().submit(() -> {
      while (true) {
        while (!buffer.isEmpty()) {
          // Batching.
          sink.publish(buffer.poll());
        }
      }
    });
    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  System.out.println("Received shutdown signal, Finish publishing existng msgs to sink");
                  while (!buffer.isEmpty()) {
                    // Batching.
                    sink.publish(buffer.poll());
                  }
                  task.cancel(true);
                }));

//    Runtime.getRuntime().addShutdownHook();
  }

  @Override
  public void log(Message message) throws Exception {
    if (buffer.remainingCapacity() == 0) {
      throw new Exception("Buffer is full");
    }
    buffer.put(message);
  }
}
