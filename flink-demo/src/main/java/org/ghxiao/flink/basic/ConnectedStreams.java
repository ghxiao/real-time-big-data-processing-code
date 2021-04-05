package org.ghxiao.flink.basic;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.CoFlatMapFunction;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConnectedStreams {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> control =
                env.fromElements("DROP", "IGNORE");
        DataStream<String> data =
                env.fromElements("data", "DROP", "artisans", "IGNORE");
        DataStream<String> result = control
                .broadcast()
                .connect(data)
                .flatMap(new MyCoFlatMap());
        result.print();
        env.execute();
    }

    private static final class MyCoFlatMap
            implements CoFlatMapFunction<String, String, String> {
        HashSet blacklist = new HashSet();
        @Override
        public void flatMap1(String control_value, Collector<String> out) {
            blacklist.add(control_value);
            out.collect("listed " + control_value);
        }
        @Override
        public void flatMap2(String data_value, Collector<String> out) {
            if (blacklist.contains(data_value)) {
                out.collect("skipped " + data_value);
            } else {
                out.collect("passed " + data_value);
            }
        }
    }
}
