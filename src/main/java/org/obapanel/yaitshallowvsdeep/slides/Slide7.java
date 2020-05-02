package org.obapanel.yaitshallowvsdeep.slides;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Slide7 {


    public static class Robot implements Cloneable, Serializable {

        private String name;

        private boolean active;

        public Robot() {}

        public Robot(String name, boolean active) {
            this.name = name;
            this.active = active;
        }

        public Robot makeCopy() {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(this);
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);
                return (Robot) ois.readObject();
            } catch (Exception e) {
                throw new IllegalStateException("Error cloning with byte array stream",e);
            }
        }

    }

    public static void slide7() {
        List<Robot> robotsOriginal = Arrays.asList(new Robot("Bender", true), new Robot("R2D2", false), new Robot("WALL-E", true));
        List<Robot> robotsDeep = new ArrayList<>(robotsOriginal.size());
        robotsOriginal.forEach( r -> robotsDeep.add((Robot)r.makeCopy()));

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
        Slide7.slide7();
    }

}
