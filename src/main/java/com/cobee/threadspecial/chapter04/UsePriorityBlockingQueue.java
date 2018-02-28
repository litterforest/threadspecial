package com.cobee.threadspecial.chapter04;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class UsePriorityBlockingQueue {

	public static void main(String[] args) {
		
		PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>(3, new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				if (i1 < i2)
				{
					return 1;
				}
				else if (i1 > i2)
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}});
		
		queue.add(6);
		queue.add(1);
		queue.add(7);
		
		System.out.println(queue);
		
	}

}
