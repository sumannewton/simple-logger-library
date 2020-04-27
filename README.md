# simple-logger-library
A simple logging library in JAVA.

## Requirements
 - JAVA 1.11
 - Maven 3

## Build Instructions

This project is built using [Apache Maven](http://maven.apache.org/).

Run the following command from the root of repository, to build the client JAR:
- Clone the source:
```
$ git clone https://github.com/sumannewton/logger-library.git
```
- Build
```
$ mvn clean install
```

## Usage

The following piece of code initializes the logger:
```
Config config = Config.builder()
    .logConfig(LogConfig.builder()
        .loggerType(LoggerType.SYNC)
        .ts_format("dd-mm-yyyy-hh-mm-ss")
        .bufferSize(25)
        .build())
    .sinkConfig(SinkConfig.builder()
        .level(LogLevel.FATAL)
        .sinkType(SinkType.STDOUT)
        .build())
    .build();
Logger logger = LogManager.getLogger(config);
```

Using the logger:
```
logger.warn("This is a sample warn.");
logger.debug("This is a sample debug");
logger.error("This is a sample error.");
logger.fatal("This is a sample fatal.");
logger.info("This is a sample info.");    
```