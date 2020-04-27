package com.newton.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
  private String message;
  private LogLevel level;
  private String timestamp;
}