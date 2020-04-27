package com.newton.config;

import com.newton.model.LogLevel;
import com.newton.model.SinkType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SinkConfig {

  private SinkType sinkType;
  private LogLevel level;
}
