package org.obapanel.yaitlambdas.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example3_Streams_vs_Imperative_Lists {

    List<String> list = Arrays.asList("");

    /*
    EXAMPLE 1
    Check if there is any empty string
     */
    public boolean exampleWithLamda1() {
        return list.stream().
                anyMatch(String::isEmpty);
    }

    public boolean exampleWithImperative1() {
        for(String s: list){
            if (s.isEmpty()){
                return true;
            }
        }
        return false;
    }

    /*
    EXAMPLE 2
    Return the list without empty strings
     */
    public List<String> exampleWithLamda2() {
        return list.stream().
                filter( s -> !s.isEmpty()).
                collect(Collectors.toList());
    }

    public List<String> exampleWithImperative2() {
        List<String> result = new ArrayList<>();
        for(String s: list){
            if (!s.isEmpty()){
                result.add(s);
            }
        }
        return result;
    }

        /*
    EXAMPLE 3
    Return the list with the string sizes
     */
    public List<Integer> exampleWithLamda3() {
        return list.stream().
                map(s -> s.length()).
                collect(Collectors.toList());
    }

    public List<Integer> exampleWithImperative3() {
        List<Integer> result = new ArrayList<>();
        for(String s: list){
            result.add(s.length());
        }
        return result;
    }


    /*
    EXAMPLE 3
    Return the list with the string sizes except empty ones
    */
    public List<Integer> exampleWithLamda4a() {
        return list.stream().
                filter(s -> !s.isEmpty()).
                map(String::length).
                collect(Collectors.toList());
    }

    public List<Integer> exampleWithLamda4b() {
        return list.stream().
                map(String::length).
                filter(i -> i > 0).
                collect(Collectors.toList());
    }


    public List<Integer> exampleWithImperative4() {
        List<Integer> result = new ArrayList<>();
        for(String s: list){
            if (!s.isEmpty()) {
                result.add(s.length());
            }
        }
        return result;
    }


}
