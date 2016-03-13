package com.github.java.thread;

import java.math.BigInteger;
import java.security.InvalidParameterException;

public class FactorialThread implements Runnable {
	private Thread thread;
	private int id;

	public FactorialThread(int id) {
		super();
		this.id = id;
		thread = new Thread(this);
		thread.start();
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public Thread getThread() {
		return thread;
	}

	private static BigInteger getFactorial(int n) throws InvalidParameterException {
		BigInteger r = BigInteger.ZERO;
		if (n > 0) {
			r = BigInteger.valueOf(1);
			for (int i = 2; i <= n; ++i)
				r = r.multiply(BigInteger.valueOf(i));
		} else if (n == 0) {
			r = BigInteger.valueOf(1);
		} else {
			throw new InvalidParameterException();
		}
		return r;
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread = " + id + " Factorial = " + getFactorial(id));
		} catch (InvalidParameterException ex) {
			System.out.println("Factorial from negative number doesn't exist");
		}
	}
}
