package org.obapanel.yaitshallowvsdeep.slides;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Slide2 {


    public static class Robot {

        private String name;

        private boolean active;

        public Robot() {}

        public Robot(String name, boolean active) {
            this.name = name;
            this.active = active;
        }

    }

    public static void slide2() {
        List<Robot> robotsOriginal = Arrays.asList(new Robot("Bender", true), new Robot("R2D2", false), new Robot("WALL-E", true));
        List<Robot> robotsShallow = new ArrayList<>(robotsOriginal);

        assert robotsOriginal.get(0).active;
        checkCondition(robotsOriginal.get(0).active);

        robotsOriginal.get(0).active = false;

        assert !robotsOriginal.get(0).active;
        checkCondition(!robotsOriginal.get(0).active);

        assert !robotsShallow.get(0).active;
        checkCondition(!robotsShallow.get(0).active);

    }


    public static void checkCondition(boolean condition ){
        if (!condition){
            throw new IllegalStateException("Condition is false");
        }
    }

    public static void main(String[] args) {
        Slide2.slide2();
    }
}
