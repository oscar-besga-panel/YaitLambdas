package org.obapanel.yaitlambdas.slides;

import java.io.Serializable;

public class Slide18 {

    /*
    Good example
     */
    @FunctionalInterface
    public static interface Calculatesomething {

        float calculate(float xLowLimit, float xUpLimit, float yLowLimit, float yUpLimit);

        default Calculatesomething invert(){
            return (xl, xu, yl, yu) -> -1f * calculate(xl, xu, yl, yu);
        }

    }

    /*
    We could use a Function that accepts an object of 4 floats and returns another float !!!!
     */

    static void printResult(Calculatesomething calculatesomething){
        System.out.println("Result is " + calculatesomething.calculate(0,1,0,1));
    }

    static void printInvertResult(Calculatesomething calculatesomething){
        System.out.println("Result is " + calculatesomething.invert().calculate(0,1,0,1));
    }



    static void example1() {
        printResult((xl, xu, yl, yu) -> {
            return xl + xu + yl + yu;
        });
        printInvertResult((xl, xu, yl, yu) -> {
            return xl + xu + yl + yu;
        });
        Calculatesomething c = (xl, xu, yl, yu) -> {
            return xl + xu + yl + yu;
        };
        c.invert().calculate(1,1,1,1);
    }


    /*
    Bad example
    */
    @FunctionalInterface
    public static interface ProduceAnyResult extends Serializable {

        float calculate(float xLowLimit, float xUpLimit, float yLowLimit, float yUpLimit);

        //Nope
        // float calculate(String points)

        //Nope
        // float calculate(float xLowLimit, float xUpLimit, float yLowLimit, float yUpLimit, int fraction);

        //Nope
        //float calculate(float... xLowLimit);

        default float calculate(String... nums){
            float xLowLimit = Float.parseFloat(nums[0]);
            float xUpLimit = Float.parseFloat(nums[1]);
            float yLowLimit = Float.parseFloat(nums[2]);
            float yUpLimit = Float.parseFloat(nums[3]);
            return calculate(xLowLimit, xUpLimit, yLowLimit, yUpLimit);
        }

        default float getSomething(){
            return 0.0f;
        }

        default float getOtherThing(){
            return 0.0f;
        }

    }

    static void shoutResult(ProduceAnyResult produceIntegral){
        System.out.println("Result is " + produceIntegral.calculate(0,1,0,1));
    }

    static void shoutOtherResult(ProduceAnyResult produceIntegral){
        System.out.println("Result is " + produceIntegral.calculate("0","1","0","1"));
    }


    static void example2() {
        shoutResult((xl, xu, yl, yu) -> {
            return xl + xu + yl + yu;
        });
        shoutOtherResult((xl, xu, yl, yu) -> {
            return xl + xu + yl + yu;
        });

        ProduceAnyResult p = (xl, xu, yl, yu) -> {
            return xl + xu + yl + yu;
        };
        p.calculate(1,1,1,1);
        p.calculate("1","2","3","4");
    }


}
