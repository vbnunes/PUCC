package com.puc.serial.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	private static final int BASE_ARRAY_SIZE = 10000;

	public static void main(String[] args) {
		int i = 1;
		for (i = 1; i < 10000; i *= 10) {
			int size = BASE_ARRAY_SIZE * i;
			// Gera um array com números randômicos
			int[] array1 = generateArray(size);
			// printArray(array1);

			// Criando cópias do array1 para que todos os algoritmos
			// de ordenação usem o mesmo conjunto de dados
			int[] array2 = Arrays.copyOf(array1, array1.length);
			int[] array3 = Arrays.copyOf(array1, array1.length);
			int[] array4 = Arrays.copyOf(array1, array1.length);
			int[] array5 = Arrays.copyOf(array1, array1.length);
			int[] array6 = Arrays.copyOf(array1, array1.length);
			int[] array7 = Arrays.copyOf(array1, array1.length);

			// Tamanho array
			System.out.println("Array Size: " + size);

			long startTime, endTime;

			// Ordenando array1 usando BubbleSort
			startTime = System.currentTimeMillis();
			BubbleSort bs = new BubbleSort();
			bs.sort(array1);
			endTime = System.currentTimeMillis();
			System.out.println("Tempo com Bubble Sort.........: " + (endTime - startTime) + "ms.");
			// printArray(array1);

			// Ordenando array2 usando Selection Sort
			startTime = System.currentTimeMillis();
			SelectionSort ss = new SelectionSort();
			ss.sort(array2);
			endTime = System.currentTimeMillis();
			System.out.println("Tempo com Selection Sort......: " + (endTime - startTime) + "ms.");
			// printArray(array2);

			// Ordenando array3 usando Insertion Sort
			startTime = System.currentTimeMillis();
			InsertionSort is = new InsertionSort();
			is.sort(array3);
			endTime = System.currentTimeMillis();
			System.out.println("Tempo com Insertion Sort......: " + (endTime - startTime) + "ms.");
			// printArray(array3);

			// Ordenando array4 usando Merge Sort
			startTime = System.currentTimeMillis();
			MergeSort ms = new MergeSort();
			ms.sort(array4, 0, size - 1);
			endTime = System.currentTimeMillis();
			System.out.println("Tempo com Merge Sort..........: " + (endTime - startTime) + "ms.");
			// printArray(array4);

			// Ordenando array5 usando Quick Sort
			startTime = System.currentTimeMillis();
			QuickSort qs = new QuickSort();
			qs.sort(array5, 0, size - 1);
			endTime = System.currentTimeMillis();
			System.out.println("Tempo com Quick Sort..........: " + (endTime - startTime) + "ms.");
			// printArray(array5);

			// Ordenando array6 usando Arrays.sort()
			startTime = System.currentTimeMillis();
			Arrays.sort(array6, 0, size - 1);
			endTime = System.currentTimeMillis();
			System.out.println("Tempo com Arrays.sort.........: " + (endTime - startTime) + "ms.");
			// printArray(array6);

			// Ordenando array7 usando Arrays.parallelSort()
			startTime = System.currentTimeMillis();
			Arrays.parallelSort(array7, 0, size - 1);
			endTime = System.currentTimeMillis();
			System.out.println("Tempo com Arrays.parallelSort.: " + (endTime - startTime) + "ms.");
			// printArray(array7);
		}

	}

	public static int[] generateArray(int size) {
		if (size <= 0 || size > Integer.MAX_VALUE)
			return null;

		int[] result = new int[size];
		for (int i = 0; i < size; i++)
			result[i] = ThreadLocalRandom.current().nextInt(0, (size + 1) * 2);

		return result;
	}

	private static void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (i % 15 == 0)
				System.out.println();
			System.out.print(arr[i] + "\t");
		}
	}
}
