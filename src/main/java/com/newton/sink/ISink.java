package com.newton.sink;

import com.newton.model.Message;

public interface ISink {

  void init();

  void publish(Message message);
}
