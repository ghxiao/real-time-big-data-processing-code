package org.ghxiao.flink.scala.basic

import org.apache.flink.streaming.api.scala._

object WordCount {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    //env.setStreamTimeCharacteristic()
    val text = env.socketTextStream("localhost", 9999)

    val counts: DataStream[(String, Int)] =
      text.flatMap(_.toLowerCase.split("\\W+"))
        .filter(_.nonEmpty)
        .map((_, 1))
        // group by the tuple field "0" and sum up tuple field "1"
        .keyBy(0)
        .sum(1)

    counts.print()

    // execute program
    env.execute("Streaming WordCount")
  }
}
