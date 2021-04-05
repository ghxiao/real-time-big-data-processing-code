package org.ghxiao.flink.basic;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

public class WordCount {
    public static void main(String[] args) throws Exception {
        // set up the execution environment

        //Configuration conf = new Configuration();
        //final StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(new Configuration());

        final StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();
        // configure event time
        env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime);
        DataStream<Tuple2<String, Integer>> counts = env
                // read stream of words from socket
                .socketTextStream("localhost", 9999)
                // split up the lines in tuples containing: (word,1)
                .flatMap(new Splitter())
                // key stream by the tuple field "0"
                .keyBy(0)
                // compute counts every 5 minutes
                //.timeWindow(Time.minutes(5))
                //sum up tuple field "1"
                .sum(1);
        // print result in command line
        counts.print();
        // execute program
        env.execute("Socket WordCount Example");
    }

    private static class Splitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String value,
                            Collector<Tuple2<String, Integer>> out)
                throws Exception {
// normalize and split the line
            String[] tokens = value.toLowerCase().split("\\W+");
// emit the pairs
            for (String token : tokens) {
                if (token.length() > 0) {
                    out.collect(
                            new Tuple2<String, Integer>(token, 1));
                }
            }
        }
    }

}
