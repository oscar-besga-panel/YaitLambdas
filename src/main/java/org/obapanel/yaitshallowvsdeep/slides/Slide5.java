package org.obapanel.yaitshallowvsdeep.slides;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Slide5 {


    public static class Robot implements Cloneable {

        private String name;

        private boolean active;

        public Robot() {}

        public Robot(String name, boolean active) {
            this.name = name;
            this.active = active;
        }

        public Object clone() {
            Robot other = new Robot();
            other.active = active;
            other.name = name;
            return other;
        }


    }

    public static void slide5() {
        List<Robot> robotsOriginal = Arrays.asList(new Robot("Bender", true), new Robot("R2D2", false), new Robot("WALL-E", true));
        List<Robot> robotsDeep = new ArrayList<>(robotsOriginal.size());
        robotsOriginal.forEach( r -> robotsDeep.add((Robot)r.clone()));

        assert robotsOriginal.get(0).active;
        checkCondition(robotsOriginal.get(0).active);

        robotsOriginal.get(0).active = false;

        assert !robotsOriginal.get(0).active;
        checkCondition(!robotsOriginal.get(0).active);

        assert robotsDeep.get(0).active;
        checkCondition(robotsDeep.get(0).active);
    }

    public static void checkCondition(boolean condition ){
        if (!condition){
            throw new IllegalStateException("Condition is false");
        }
    }

    public static void main(String[] args) {
        Slide5.slide5();
    }

}
