package com.cobee.threadspecial.chapter03;

import java.util.Iterator;
import java.util.Vector;

/**
 * ͬ�����ϵ�ʹ�������⣬����߳�ͬʱ����Vectorʱ�����ĳ���߳��ڵ�����ʱ����һ���߳��޸��˼��������Ԫ�أ���ʱ����׳�ConcurrentModificationException�쳣
 * @author Administrator
 *
 */
public class Tickets {

	public static void main(String[] args) {
		final Vector<String> tickets = new Vector<String>();
		for (int i = 0; i < 1000; i++)
		{
			tickets.add("��Ʊ" + (i + 1));
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
