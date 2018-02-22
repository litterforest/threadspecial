package com.cobee.threadspecial.chapter02;

/**
 * volatile关键字使变量在线程之间可见
 * 
 * @author Administrator
 *
 */
public class RunningThread extends Thread {

	// volatile
	private volatile boolean isRunning = true;

	@Override
	public void run() {
		System.out.println("线程开始...");
		while (isRunning) {
			// 执行代码
		}
		System.out.println("线程结束");

	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public static void main(String[] args) {
		RunningThread runningThread = new RunningThread();
		Thread t1 = new Thread(runningThread, "t1");
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("设置线程isRunning属性为false");
		runningThread.setRunning(false);
	}

}
