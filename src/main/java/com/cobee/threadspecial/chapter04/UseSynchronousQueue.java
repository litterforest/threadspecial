package com.cobee.threadspecial.chapter04;

import java.util.concurrent.SynchronousQueue;

public class UseSynchronousQueue {

	public static void main(String[] args) {
		SynchronousQueue<String> queue = new SynchronousQueue<String>();
		String element = queue.poll();
		System.out.println(element);
		queue.add("111111");
		System.out.println();
	}

}
