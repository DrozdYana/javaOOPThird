package com.github.java.thread.array;

public class SingleThreadAdding implements Runnable {
	private int[] array;
	private int begin;
	private int end;
	private Thread thread;
	private int index;
	private boolean stop = false;

	public SingleThreadAdding(int[] array, int begin, int end) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
		thread = new Thread(this);
		thread.start();
		this.index = begin;
	}

	public Thread getThread() {
		return thread;
	}
	public int pollElement() {
		int temp = array[index];
		check();
		return temp;
	}

	public boolean isStop() {
		return stop;
	}

	private void check() {
		this.index++;
		if (this.index >= this.end) {
			this.stop = true;
		}
	}

	@Override
	public void run() {
		int sum = 0;
		for (int i = begin; i < end; i++) {
			sum += array[i];
		}
		
	}

}
