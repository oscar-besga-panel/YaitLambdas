package org.obapanel.yaitlambdas.examples;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Example2_LamdasAndEnums {

    /*
    Have some fixed functionality enumerated
     */


    public static enum Operations {
        ADD( (x,y) -> {
            return x + y;
        }),
        SUB((x,y) -> {
            return x - y;
        }),
        MUL((x,y) -> {
            return x * y;
        }),
        DIV((x,y) -> {
            return x / y;
        }),
        POT((x,y) -> {
            return x ^ y;
        });

        BiFunction<Long, Long, Long> operation;

        Operations(BiFunction<Long, Long, Long> operation) {
            this.operation = operation;
        }

        public BiFunction<Long, Long, Long> getOperation() {
            return operation;
        }

        public Long operate(Long x, Long y){
            return operation.apply(x,y);
        }

    }

    public void example() {
        Stream.of(Operations.values()).forEach( o -> {
            System.out.println(String.format("Operation %s result %d", o.name(), o.operate(2l,1l)));
        });

    }
}
