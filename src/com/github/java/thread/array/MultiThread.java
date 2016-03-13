package com.github.java.thread.array;

public class MultiThread {
	static void add(int[] array, int threadNumber) {
		SingleThreadAdding[] threadarray = new SingleThreadAdding[threadNumber];
		for (int i = 0; i < threadarray.length; i++) {
			int size = array.length / threadNumber;
			int begin = size * i;
			int end = ((i + 1) * size);
			if ((array.length - end) < size) {
				end = array.length;
			}
			threadarray[i] = new SingleThreadAdding(array, begin, end);
		}

		for (int i = 0; i < threadarray.length; i++) {

			try {
				threadarray[i].getThread().join();

			} catch (InterruptedException e) {
				System.out.println(e);
			}

		}
		int sum = mergeSum(array, threadarray);
		System.out.println("Sum multy thread = " + sum);
	}

	private static int mergeSum(int[] array, SingleThreadAdding[] threadarray) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {

			int k = -1;
			for (int j = 0; j < threadarray.length; j++) {
				
				if (!threadarray[j].isStop()) {
					k = j;
				}
			}

			if (k != -1) {

				sum += threadarray[k].pollElement();

			}

		}

		return sum;
	}

}
