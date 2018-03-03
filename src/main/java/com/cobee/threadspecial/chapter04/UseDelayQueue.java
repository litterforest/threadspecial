package com.cobee.threadspecial.chapter04;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class UseDelayQueue {

	public static void main(String[] args) throws InterruptedException {
		
		final DelayQueue<CountDownItem> delayQueue = new DelayQueue<CountDownItem>();
		CountDownItem countDownItem = new CountDownItem(5L, "5√ÎΩ· ¯¡À");
		delayQueue.add(countDownItem);
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				CountDownItem cd1 = delayQueue.poll();
				System.out.println(cd1.getMessage());
				
			}}).start();
//		
//		TimeUnit unit = TimeUnit.SECONDS;
//		System.out.println(unit.convert(30L, TimeUnit.HOURS));
		
	}
	
	static class CountDownItem implements Delayed {
		
		private long delayedSecond = 0;
		private String message;
		
		public CountDownItem(long delayedSecond, String message)
		{
			this.delayedSecond = delayedSecond;
			this.message = message;
		}
		
		public String getMessage()
		{
			return this.message;
		}

		@Override
		public int compareTo(Delayed delayed) {
			return 1;
		}

		@Override
		public long getDelay(TimeUnit unit) {
//			System.out.println(unit);
//			delayedSecond--;
//			return unit.convert(delayedSecond, TimeUnit.SECONDS);
			return delayedSecond;
		}
		
	}
	
}
