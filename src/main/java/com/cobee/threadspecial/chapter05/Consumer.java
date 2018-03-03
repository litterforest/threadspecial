package com.cobee.threadspecial.chapter05;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

	private BlockingQueue<String> queue;
	
	public Consumer(BlockingQueue<String> queue)
	{
		this.queue = queue;
	}
	
	@Override
	public void run() {
		
		while (true)
		{
			try {
				String element = queue.poll(3, TimeUnit.SECONDS);
				if (element == null)
				{
					break;
				}
				// ģ�������ߵĴ���ʱ��
				long sleepTime = (long)(Math.random() * 1000.0D);
				Thread.sleep(sleepTime);
				System.out.println(Thread.currentThread().getName() + " �����ߴ�����[" + element + "]");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
