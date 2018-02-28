package com.cobee.threadspecial.chapter03;

import java.util.Iterator;
import java.util.Vector;

/**
 * 同步集合的使用与问题，多个线程同时操作Vector时，如果某个线程在迭代的时候，另一个线程修改了集合里面的元素，这时入会抛出ConcurrentModificationException异常
 * @author Administrator
 *
 */
public class Tickets {

	public static void main(String[] args) {
		final Vector<String> tickets = new Vector<String>();
		for (int i = 0; i < 1000; i++)
		{
			tickets.add("火车票" + (i + 1));
		}
		
		new Thread(new Runnable() {

			@Override
			public void run() {
//				for (int i = 0; i < tickets.size(); i++)
//				{
//					try {
//						Thread.sleep(5);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					tickets.get(i);
//				}
				
				Iterator<String> iterator = tickets.iterator();
				while (iterator.hasNext())
				{
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					iterator.next();
				}
				
			}}).start();
		
		for (int i = 0; i < 10; i++)
		{
			new Thread(new Runnable() {

				@Override
				public void run() {
					while(true)
					{
						if (tickets.size() > 0)
						{
							System.out.println(Thread.currentThread().getName() + " get " + tickets.remove(0));
						}
						else
						{
							break;
						}
					}
					
				}}, "T" + i).start();
		}
		
	}

}
