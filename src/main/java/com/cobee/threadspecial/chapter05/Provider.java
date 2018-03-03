package com.cobee.threadspecial.chapter05;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Provider implements Runnable {

	private static final AtomicInteger count = new AtomicInteger();
	
	private BlockingQueue<String> queue;
	
	private volatile boolean isRunning = true;
	
	public Provider(BlockingQueue<String> queue)
	{
		this.queue = queue;
	}
	
	@Override
	public void run() {
		
		while (isRunning)
		{
			// 模拟生产数据需要用到的时间
			long sleepTime = ((long) (Math.random() * 1000.0D));
			try {
				Thread.sleep(sleepTime);
				// 生产一个数字
				int number = count.incrementAndGet();
				System.out.println(Thread.currentThread().getName() + "生产者生产出第" + number + "条数据,并且放进到缓存队列中");
				if (!queue.offer(String.valueOf(number), 2, TimeUnit.SECONDS))
				{
					System.out.println(Thread.currentThread().getName() + "第" + number + "条数据添加失败");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void stop()
	{
		this.isRunning = false;
	}
	
	public static void main(String[] args) {
		double sleepD = Math.random() * 1000.0D;
		System.out.println(sleepD);
		long sleepTime = ((long) sleepD);
		System.out.println(sleepTime);
	}
	
}
