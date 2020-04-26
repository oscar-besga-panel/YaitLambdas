package org.obapanel.yaitlambdas.slides;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Slide7 {

    List<String> list = Arrays.asList("");

    public void exampleLamdaWithoutStreams() {
        list.forEach(s -> System.out.println(s));
    }

    public void exampleLamdaWithStream() {
        list.stream().forEach(s -> System.out.println(s));
    }

}
