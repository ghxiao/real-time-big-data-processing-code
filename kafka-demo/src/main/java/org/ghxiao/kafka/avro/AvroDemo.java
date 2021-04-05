package org.ghxiao.kafka.avro;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.ghxiao.kafka.avro.model.ShakespeareKey;

import java.io.File;
import java.io.IOException;

public class AvroDemo {
    public static void main(String[] args) throws IOException {
//        ShakespeareKey key1 = new ShakespeareKey("Romeo and Juliet", 1594);
//
//        ShakespeareKey key2 = ShakespeareKey.newBuilder()
//                .setYear(1600)
//                .setWork("Hamlet")
//                .build();
//
//        DatumWriter<ShakespeareKey> userDatumWriter
//                = new SpecificDatumWriter<>(ShakespeareKey.class);
//
//        DataFileWriter<ShakespeareKey> dataFileWriter = new DataFileWriter<>(userDatumWriter);

        final String file = "src/main/resources/avro/shakespeare_key.avro";

//        dataFileWriter.create(ShakespeareKey.getClassSchema(), new File(file));
//
//        dataFileWriter.append(key1);
//        dataFileWriter.append(key2);

//        dataFileWriter.close();

        DatumReader<ShakespeareKey> userDatumReader =
                new SpecificDatumReader<>(ShakespeareKey.class);
        DataFileReader<ShakespeareKey> dataFileReader =
                new DataFileReader<>(new File(file), userDatumReader);
        ShakespeareKey key = null;
        while (dataFileReader.hasNext()) {
            // Reuse user object by passing it to next(). This saves us from
            // allocating and garbage collecting many objects for files with
            // many items.
            //key = dataFileReader.next(key);
            key = dataFileReader.next();
            System.out.println(key);
        }
    }
}
