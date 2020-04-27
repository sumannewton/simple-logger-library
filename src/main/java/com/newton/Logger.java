package com.newton;

public interface Logger {

  void debug(String message) throws Exception;

  void info(String message) throws Exception;

  void warn(String message) throws Exception;

  void error(String message) throws Exception;

  void fatal(String message) throws Exception;
}
