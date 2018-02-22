package com.cobee.threadspecial.chapter02;

/**
 * volatile�ؼ���ʹ�������߳�֮��ɼ�
 * 
 * @author Administrator
 *
 */
public class RunningThread extends Thread {

	// volatile
	private volatile boolean isRunning = true;

	@Override
	public void run() {
		System.out.println("�߳̿�ʼ...");
		while (isRunning) {
			// ִ�д���
		}
		System.out.println("�߳̽���");

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
		System.out.println("�����߳�isRunning����Ϊfalse");
		runningThread.setRunning(false);
	}

}
