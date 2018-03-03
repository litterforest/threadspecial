package com.cobee.threadspecial.chapter05;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ClientTester {

	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(15);
		
		Provider p1 = new Provider(queue);
		Provider p2 = new Provider(queue);
		Provider p3 = new Provider(queue);
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);
		
		ExecutorService pools = Executors.newCachedThreadPool();
		pools.execute(p1);
		pools.execute(p2);
		pools.execute(p3);
		pools.execute(c1);
		pools.execute(c2);
		pools.execute(c3);
		
		Thread.sleep(3000);
		
		p1.stop();
		p2.stop();
		p3.stop();
		
		// 标志线程池已经关闭了，里面的线程执行完毕后结束
		pools.shutdown();
		
	}

}
