package com.cobee.threadspecial.chapter04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UseConcurrentLinkedQueue {

	public static void main(String[] args) throws InterruptedException {
		// 高性能无阻塞线程安全的队列
//		final LinkedList<String> concurrentLinkedQueue = new LinkedList<String>();
		final ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();
		
		for (int i = 0; i < 5; i++)
		{
			final int j = i;
			new Thread(new Runnable() {

				@Override
				public void run() {
					
					if (j == 0)
					{
						concurrentLinkedQueue.add("a");
						concurrentLinkedQueue.add("b");
						concurrentLinkedQueue.add("c");
						concurrentLinkedQueue.add("d");
						concurrentLinkedQueue.add("e");
					}
					else if (j == 1)
					{
						concurrentLinkedQueue.add("f");
						concurrentLinkedQueue.add("g");
						concurrentLinkedQueue.add("h");
						concurrentLinkedQueue.add("i");
						concurrentLinkedQueue.add("j");
					}
					else if (j == 2)
					{
						concurrentLinkedQueue.add("k");
						concurrentLinkedQueue.add("l");
						concurrentLinkedQueue.add("m");
						concurrentLinkedQueue.add("n");
						concurrentLinkedQueue.add("o");
					}
					else if (j == 3)
					{
						concurrentLinkedQueue.add("p");
						concurrentLinkedQueue.add("q");
						concurrentLinkedQueue.add("r");
						concurrentLinkedQueue.add("s");
						concurrentLinkedQueue.add("t");
					}
					else if (j == 4)
					{
						concurrentLinkedQueue.add("u");
						concurrentLinkedQueue.add("v");
						concurrentLinkedQueue.add("w");
						concurrentLinkedQueue.add("x");
						concurrentLinkedQueue.add("y");
						concurrentLinkedQueue.add("z");
					}
					
				}}).start();
		}
		
		Thread.sleep(2000);
		System.out.println(concurrentLinkedQueue);
		System.out.println(concurrentLinkedQueue.size());
		concurrentLinkedQueue.poll();
		System.out.println(concurrentLinkedQueue);
		System.out.println(concurrentLinkedQueue.size());
		concurrentLinkedQueue.peek();
		System.out.println(concurrentLinkedQueue);
		System.out.println(concurrentLinkedQueue.size());
	}

}
