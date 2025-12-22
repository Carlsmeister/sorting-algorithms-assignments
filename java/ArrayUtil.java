import java.util.Random;

public class ArrayUtil {
    public static void shuffle(int[] a) {
        int N = a.length;
        Random randomGenerator = new Random();
        for (int i = 0; i < N; i++) {
            int r = i + randomGenerator.nextInt(N-i);     // between i and N-1
            int t = a[i]; a[i] = a[r]; a[r] = t;
        }
    }

    public static int[] createOrdered(int N) {
        int[] a = new int[N];
        Random randomGenerator = new Random();
        for (int i = 0, x = 0; i < N; i++) {
            x += randomGenerator.nextInt(5);
            a[i] = x;
        }
        return a;
    }

    public static int[] createShuffeled(int N) {
        int[] a = createOrdered(N);
        shuffle(a);
        return a;
    }

    public static class SortingException extends RuntimeException {
        public SortingException(String message) { super(message); }
    }

    /** Throws ArrayUtils.SortingException if a is not sorted. */
    public static void testOrdered(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            if (a[i] < a[i-1]) {
                throw new SortingException("Not sorted, a["+(i-1)+"] > a["+i+"]");
            }
        }
    }
}
