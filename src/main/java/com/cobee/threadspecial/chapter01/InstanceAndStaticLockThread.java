package com.cobee.threadspecial.chapter01;

/**
 * 实例锁与静态锁的区别
 * 
 * @author Administrator
 *
 */
public class InstanceAndStaticLockThread {

	private static int num = 0;

	public static synchronized void printNum(String tag) {
		try {
			if ("a".equals(tag)) {
				num = 100;
				System.out.println("tag " + tag + " set num over");

				Thread.sleep(1000);

			} else if ("b".equals(tag)) {
				num = 200;
				System.out.println("tag " + tag + " set num over");
			}

			System.out.println("tag " + tag + " num = " + num);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final InstanceAndStaticLockThread iast1 = new InstanceAndStaticLockThread();
		final InstanceAndStaticLockThread iast2 = new InstanceAndStaticLockThread();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				iast1.printNum("a");
			}});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				iast2.printNum("b");
			}});
		t1.start();
		t2.start();
	}
	
}
