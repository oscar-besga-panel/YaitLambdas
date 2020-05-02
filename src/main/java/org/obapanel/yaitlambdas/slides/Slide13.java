package org.obapanel.yaitlambdas.slides;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Slide13 {

    List<String> list = Arrays.asList("");


    public void exampleReduce() {
        // Sum from 1 to 10
        IntStream.range(1, 11).reduce(0, (a, b) -> a + b);
    }

    public void exampleCollect() {
        // All in UPPERCASE
        List<String> upperCases = list.stream().
                map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public void exampleForEach() {
        // Log all non empty
        list.stream()
                .filter(s -> !s.isEmpty())
                .forEach(System.out::println);
    }

    public void examplesFindTerminal() {
        // Print the first non empty string, if any
        list.stream().
                filter(s -> !s.isEmpty()).
                findFirst().
                ifPresent(System.out::println);
        // Print a non empty string, if any
        list.stream().
                filter(s -> !s.isEmpty()).
                findAny().
                ifPresent(System.out::println);
    }


    public void examplesMatch() {
        // Any stirng is not empty
        boolean checkAny = list.stream().
                anyMatch(s -> !s.isEmpty());
        // All strings should be non empty
        boolean checkAll = list.stream().
                allMatch(s -> !s.isEmpty());
        // All strings should be empty
        boolean checkNone = list.stream().
                noneMatch(s -> !s.isEmpty());
    }

    public void exampleCount() {
        // How many non-empty strings
        long num = list.stream().
                filter(s -> !s.isEmpty()).
                count();
    }

    public void examplesMaxMinAvg() {
        int max = IntStream.range(1, 11).max().getAsInt();
        int min = IntStream.range(1, 11).min().getAsInt();
        double avg = IntStream.range(1, 11).average().getAsDouble();
    }

}