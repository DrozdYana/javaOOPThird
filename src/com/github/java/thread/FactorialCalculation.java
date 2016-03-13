package com.github.java.thread;

public class FactorialCalculation {
	public void factorialByThread(int begin, int count) {
		int end = begin + count;
		for (; begin < end; begin++) {
			new FactorialThread(begin);
		}
	}

}
