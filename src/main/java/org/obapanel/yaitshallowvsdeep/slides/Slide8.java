package org.obapanel.yaitshallowvsdeep.slides;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Slide8 {


    public static class Robot {

        private String name;

        private boolean active;

        public Robot() {}

        public Robot(String name, boolean active) {
            this.name = name;
            this.active = active;
        }

        public Robot(Robot other) {
            this.name = other.name;
            this.active = other.active;
        }


    }

    public static void slide8() {
        List<Robot> robotsOriginal = Arrays.asList(new Robot("Bender", true), new Robot("R2D2", false), new Robot("WALL-E", true));
        List<Robot> robotsShallow = robotsOriginal.stream().
                filter(r -> r.active).
                collect(Collectors.toList());
        List<Robot> robotsDeep = robotsOriginal.stream().
                filter(r -> r.active).
                map(Robot::new).
                collect(Collectors.toList());


        assert robotsOriginal.get(0).active;
        checkCondition(robotsOriginal.get(0).active);

        assert robotsOriginal.size() == 3;
        checkCondition(robotsOriginal.size() == 3);

        assert robotsShallow.size() == 2;
        checkCondition(robotsShallow.size() == 2);

        assert robotsDeep.size() == 2;
        checkCondition(robotsDeep.size() == 2);


        robotsOriginal.get(0).active = false;

        assert !robotsOriginal.get(0).active;
        checkCondition(!robotsOriginal.get(0).active);

        assert !robotsShallow.get(0).active;
        checkCondition(!robotsShallow.get(0).active);

        assert robotsDeep.get(0).active;
        checkCondition(robotsDeep.get(0).active);
    }

    public static void checkCondition(boolean condition ){
        if (!condition){
            throw new IllegalStateException("Condition is false");
        }
    }

    public static void main(String[] args) {
        Slide8.slide8();
    }

}
