import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by vnunes on 14/09/2017.
 */
public class Main {
    private static final int TOTAL_CORES = 2;
    private static final int ARRAY_SIZE = 10;
    public static Integer total=0;
    //private final int CORES = Runtime.getRuntime().availableProcessors();
    private static ArrayList<Thread> listThreads = new ArrayList();

    public static void splitArray(int[] arr) {
        int x = 0;

        synchronized (total) {
            Thread t1 = new ArrayCalc(Arrays.copyOfRange(arr, 0, arr.length/TOTAL_CORES));
            Thread t2 = new ArrayCalc(Arrays.copyOfRange(arr, arr.length/TOTAL_CORES, arr.length));

            t1.start();
            t2.start();

            try{
                t1.join();
                t2.join();
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public static void main(String[] args) {
        int[] array = IntStream. generate(() -> (int)(Math.random()*10)).limit(ARRAY_SIZE).toArray();
        splitArray(array);

        System.out.println(total);
    }
}
