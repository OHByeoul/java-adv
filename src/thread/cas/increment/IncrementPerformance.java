package thread.cas.increment;

public class IncrementPerformance {
    public static final long COUNT = 100_000_000;

    public static void main(String[] args) {

    }

    public static void test(IncrementInteger incrementInteger) {
        long startMs = System.currentTimeMillis();

        for(long i = 0; i < COUNT; i++) {
            incrementInteger.increment();
        }

        long endMs = System.currentTimeMillis();
        System.out.println(incrementInteger.getClass().getSimpleName()+ " : " + (endMs-startMs));
    }
}
