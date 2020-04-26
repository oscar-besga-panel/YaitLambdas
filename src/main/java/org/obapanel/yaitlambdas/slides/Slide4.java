package org.obapanel.yaitlambdas.slides;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Slide4 {

    private static class Example {

        boolean isActive(){
            return true;
        }

    }

    List<Example> list = Arrays.asList(new Example());

    public boolean example1Imperative() {
        boolean result = false;
        for(Example example: list) {
            if (example.isActive()){
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean example1Functional() {
        return list.stream().
                anyMatch(Example::isActive);
    }

    public void example2Imperative() {
        ListIterator<Example> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().isActive()) {
                listIterator.remove();
            }
        }
    }

    public boolean example2Functional() {
        return list.removeIf(Example::isActive);
    }




    }
