package org.obapanel.yaitlambdas.slides;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Slide8 {

    List<String> list = Arrays.asList("");

    public void exampleStreamOneIntermediate() {
        list.stream().
                // Intermediate
                filter( (s) -> !s.isEmpty() ).
                // Termination
                forEach(s -> System.out.println(s));
    }

    public void exampleStreamManyIntermediates() {
        list.stream().
                // Intermediate
                filter( (s) -> !s.isEmpty() ).
                peek( s -> System.out.println(s.length())).
                map( s -> " " + s).
                // Termination
                forEach(s -> System.out.println(s));
    }

}
