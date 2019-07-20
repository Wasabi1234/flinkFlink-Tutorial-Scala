package com.javaedge.scala.chapter4

import org.apache.flink.streaming.api.functions.source.SourceFunction

/**
  * 自定义
  *
  * @author JavaEdge
  * @date 2019-07-19
  *
  */
class CustomNonParallelSourceFunction extends SourceFunction[Long]{

  var count = 1L
  var isRunning = true

  override def cancel(): Unit = {
    isRunning = false
  }

  override def run(ctx: SourceFunction.SourceContext[Long]): Unit = {
    while(isRunning) {
      ctx.collect(count)
      count += 1
      Thread.sleep(1000)
    }
  }
}


