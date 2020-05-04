package org.obapanel.yaitlambdas.examples;

import java.util.UUID;
import java.util.stream.Stream;

import static java.util.UUID.randomUUID;

public class Example4_InfiteStreamLimited {

    static void infiteLamdaLimited(){
        Stream.generate(UUID::randomUUID).
                limit(10).
                forEach(Example4_InfiteStreamLimited::printUUID);

    }

    static void printUUID(UUID uuid){
        System.out.println(uuid.toString());
    }

    public static void main(String[] args) {
        infiteLamdaLimited();
    }
}
