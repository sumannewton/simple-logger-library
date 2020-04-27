package com.newton.config;

import com.newton.model.LoggerType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogConfig {
  private String ts_format;
  private LoggerType loggerType;
  private int bufferSize;
}
