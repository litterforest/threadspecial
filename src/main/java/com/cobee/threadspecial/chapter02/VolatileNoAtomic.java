package com.cobee.threadspecial.chapter02;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile关键字不支持原子类型操作，是轻量版的synchronized
 * @author Administrator
 *
 */
public class VolatileNoAtomic extends Thread {

//	private volatile int num = 0;
	private AtomicInteger num = new AtomicInteger(0);
	
	private void increment()
	{
		for (int i = 0; i < 1000; i++)
		{
//			num++;
			num.incrementAndGet();
		}
		System.out.println(num);
	}

	@Override
	public void run() {
		increment();
	}
	
	public static void main(String[] args) {
		VolatileNoAtomic volatileNoAtomic = new VolatileNoAtomic();
//		VolatileNoAtomic[] volatileNoAtomics = new VolatileNoAtomic[10];
//		for (int i = 0; i < 10; i++)
//		{
//			volatileNoAtomics[i] = new VolatileNoAtomic();
//		}
		
		for (int i = 0; i < 10; i++)
		{
			Thread t = new Thread(volatileNoAtomic);
			t.start();
		}
	}
	
}
