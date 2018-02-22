package com.cobee.threadspecial.chapter01;

public class MyThread implements Runnable {

	private static int count = 5;
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " count: " + --count);
	}
	
	public static void main(String[] args) {
		Runnable executeThread = new MyThread();
		Thread t1 = new Thread(executeThread, "t1");
		Thread t2 = new Thread(executeThread, "t2");
		Thread t3 = new Thread(executeThread, "t3");
		Thread t4 = new Thread(executeThread, "t4");
		Thread t5 = new Thread(executeThread, "t5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
}
