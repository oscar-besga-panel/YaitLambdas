package org.obapanel.yaitlambdas.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example1_BasicLambdasInJava {

    void exampleOfLambdaRunnablesAndCallables() throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Print later a message
        executor.execute(() -> {
            System.out.println("Hello world");
        });

        // Recover an input from consle
        Future<String> future = executor.submit(() -> {
            return System.console().readLine();
        });

        String result = future.get();

    }

    void exampleOfLambdaOnLists() {
        List<String> list = Arrays.asList("");
        // Print list values on console
        list.forEach(System.out::println);
        // Remove any element that is empty
        list.removeIf(String::isEmpty);
    }

    void exampleOfLambdaOnMap() {
        Map<String,Integer> map = new HashMap<>();

        // Print each key value of map
        map.forEach((key, value) -> {
            System.out.println(String.format("Key %s value %d", key, value));
        });

        // Put a new value if the associated key is not present (without value) in the map
        map.computeIfAbsent("key", key -> {
            return key.length();
        });

        // Put a new value if the associated key is present (with not null value) in the map, replacing the old value
        map.computeIfPresent("key", (key,oldValue) -> {
            return oldValue + key.length();
        });

        // Put a new value with the associated key actual value (can be null) in the map, replacing the old value
        map.compute("key", (key, oldValue) -> {
            return oldValue != null ? oldValue + key.length() : key.length();
        });

        // map.merge
        // It seems too complicated to me to mention it

    }


}
