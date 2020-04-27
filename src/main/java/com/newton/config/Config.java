package com.newton.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Config {

  private LogConfig logConfig;

  private SinkConfig sinkConfig;

}
