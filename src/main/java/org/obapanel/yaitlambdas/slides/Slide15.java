package org.obapanel.yaitlambdas.slides;

import java.util.Arrays;
import java.util.List;

public class Slide15 {

    List<String> list = Arrays.asList("");

    public void createParallelStream() {
        list.parallelStream().
                filter(s -> !s.isEmpty()).
                count();
    }
}
