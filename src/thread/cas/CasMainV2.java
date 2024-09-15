package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class CasMainV2 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println("atomicInteger.get() = " + atomicInteger.get());

        int result1 = atomicInteger.incrementAndGet();
        System.out.println("result1 = " + result1);

        int result2 = atomicInteger.incrementAndGet();
        System.out.println("result2 = " + result2);

    }

    public static int incrementAndGet(AtomicInteger atomicInteger) {

        int getValue;
        boolean result = false;
        do {
            getValue = atomicInteger.incrementAndGet();
            log("getValaue = " + getValue);
            atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result = " + result);
        } while (!result);
        return getValue + 1;
    }
}
