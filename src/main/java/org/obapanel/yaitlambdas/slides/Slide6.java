package org.obapanel.yaitlambdas.slides;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Slide6 {

    ExecutorService executor = Executors.newSingleThreadExecutor();
    List<String> list = Arrays.asList("");

    public void exampleBadCode1() {
        list.forEach(s -> {
            if (s.contains("hello")) {
                System.out.println(s);
            } else {
                System.out.println("-");
            }
        });
    }

    public void exampleGoodCode1() {
        list.forEach(this::exampleGoodCode1Action);
    }

    public void exampleGoodCode1Action(String s) {
        if (s.contains("hello")) {
            System.out.println(s);
        } else {
            System.out.println("-");
        }
    }

    public void exampleBadCode2() {
        list.forEach(s -> executor.submit(() -> System.out.printf(s)));
    }

    public void exampleGoodCode2() {
        list.forEach(this::exampleGoodCode2Action);
    }

    public void exampleGoodCode2Action(String s) {
        executor.submit(() -> System.out.printf(s));
    }

}
