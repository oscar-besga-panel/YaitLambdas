package org.obapanel.yaitlambdas.slides;


import org.obapanel.yaitlambdas.examples.Example4_InfiteStreamLimited;

import java.util.Random;
import java.util.UUID;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Slide14 {

    public void generateNumericalStream() {
        // Generate a numerical stream and calculate average for int type
        IntStream.range(1, 11).average();
        IntStream.rangeClosed(1, 10).average();
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).average();
        IntStream.builder().add(1).build().average();
        // Generate a numerical stream and calculate average for long type
        LongStream.range(1L, 11L).average();
        LongStream.rangeClosed(1L, 10L).average();
        LongStream.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L).average();
        LongStream.builder().add(1).build().average();
        // Generate a numerical stream and calculate average for double type
        DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0).average();
        DoubleStream.builder().add(1.0).build().average();
    }

    public void generateStreamWithBuilder() {
        // Count the elements of a generated String from values
        Stream.<String>builder().add("").build().
                filter( s -> !s.isEmpty()).
                count();
    }

    public void generateStreamWithGenerate() {
        // Count the elements of a generated String from supplier
        /*
        WARNING
        This generates an infinte stream !!!
        Use with caution and a lot of tests

        This code as is will never end
         */
        Stream.generate(() -> "").
                filter( s -> !s.isEmpty()).
                count();
    }

    public void generateStreamWithGenerateAndLimit() {
        Stream.generate(UUID::randomUUID).
                limit(10).
                forEach(uuid -> {
                    System.out.println(uuid.toString());
                });
    }


}
