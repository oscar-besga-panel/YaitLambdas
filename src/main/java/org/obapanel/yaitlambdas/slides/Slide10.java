package org.obapanel.yaitlambdas.slides;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Slide10 {

    List<String> list = Arrays.asList("");

    /**
     * Covert the string list into numbers
     * only the first ten, but not the first element on the list
     * Return me the positives into a new list
     * Log on console thre results
     */
    public void exampleIntermediate1() {
        list.stream().
                // Jump the first
                skip(1).
                // Only the next 10
                limit(10).
                // Convert to number
                map(Integer::parseInt).
                // Only positives
                filter(s -> s > 0).
                // No repeated
                distinct().
                // Sorted please
                sorted().
                // Log it
                peek(i -> System.out.println(i)).
                // Return result at last
                collect(Collectors.toList());
    }

    public void exampleIntermediate2() {
        List<String> x = Arrays.asList("a");
        List<String> y = Arrays.asList("b","c","d");
        List<String> z = Arrays.asList("e");
        List<List<String>> multiLevel = Arrays.asList(x,y,z);
        List<String> monolevel = multiLevel.stream().
                flatMap( s -> s.stream()).
                collect(Collectors.toList());
        // a,b,c,d,e        
    }

}
