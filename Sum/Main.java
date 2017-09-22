import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	// private static final int TOTAL_CORES = 2;
	private static final int ARRAY_SIZE = 10;
	public static Integer total = 0;
	private static final int TOTAL_CORES = Runtime.getRuntime().availableProcessors();
	private static ArrayList<Thread> liThreads = new ArrayList();

	public static void splitArray(int[] arr) {
		int x = 0;

		for (int i = 0; i < TOTAL_CORES; i++) {
			if (i == 0) {
				liThreads.add(
						new ArrayCalc(Arrays.copyOfRange(arr, 0, (int)(arr.length / TOTAL_CORES) + arr.length % TOTAL_CORES)));
				liThreads.get(i).start();				
				x+=(int)(arr.length % TOTAL_CORES);
				System.out.println(liThreads.get(i).getName());				
			}else{
				liThreads.add(
						new ArrayCalc(Arrays.copyOfRange(arr, x, x + (int)(arr.length / TOTAL_CORES))));
				liThreads.get(i).start();
				System.out.println(liThreads.get(i).getName());
			}
			x += (int)(arr.length / TOTAL_CORES);
		}
		try {
			for (Thread t : liThreads) {
				t.join();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public static void main(String[] args) {
		int[] array = IntStream.generate(() -> (int) (Math.random() * 10)).limit(ARRAY_SIZE).toArray();
		for (int i=0;i<array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.print("\n");
		splitArray(array);

		System.out.println(total);
	}
}