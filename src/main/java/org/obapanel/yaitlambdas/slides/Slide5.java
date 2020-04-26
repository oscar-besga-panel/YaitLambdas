package org.obapanel.yaitlambdas.slides;

import javax.xml.ws.Holder;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Slide5 {

    List<String> list = Arrays.asList("");

    int maxLengthOfInstance;

    public void exampleFinal(final int maxLength) {
        list.removeIf(s -> s.length() > maxLength);
    }

    public void exampleEffectiveFinal(int maxLength) {
        list.removeIf(s -> s.length() > maxLength);
    }

    /*
    Not compiling
     */
    /*
    public void exampleNotFinal(int maxLength) {
        maxLength++;
        list.removeIf(s -> s.length() > maxLength);
    }
    /*
     */

    public void exampleFromClass() {
        maxLengthOfInstance++;
        list.removeIf(s -> s.length() > maxLengthOfInstance);
    }

    public void exampleWithHolder() {
        // totalsize is final, not the value holding
        final AtomicInteger totalSize = new AtomicInteger();
        list.forEach(s -> totalSize.addAndGet(s.length()));
        final Holder<StringBuilder> totalString = new Holder<>(new StringBuilder());
        list.forEach(s -> totalString.value.append(s));
    }

}
