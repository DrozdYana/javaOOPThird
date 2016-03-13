package com.github.java.thread.array;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[10];
		Random rn = new Random();
		for (int i = 0; i < array.length; i++) {

			array[i] = rn.nextInt(10);

		}
		//System.out.println("Array 1= "+Arrays.toString(array));
		int[] array2 = array.clone();
		//System.out.println("Array 2= "+Arrays.toString(array2));
		long tstart = System.currentTimeMillis();
		add(array);
		long tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + "- Static method add");
		tstart = System.currentTimeMillis();
		MultiThread.add(array2, 3);
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " - MultiThread add");
		

	}

	static void add(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println("Sum by static method = "+sum);
	}
}
