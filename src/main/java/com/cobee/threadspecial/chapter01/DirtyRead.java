package com.cobee.threadspecial.chapter01;

public class DirtyRead {
	
	private String name = "z3";
	private String password = "123";
	
	public synchronized void setValue(String name, String password)
	{
		this.name = name;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.password = password;
		System.out.println("setValue: name=" + name + ", password=" + password);
	}
	
	public synchronized void getValue()
	{
		System.out.println("getValue: name=" + name + ", password=" + password);
	}

	public static void main(String[] args) {
		final DirtyRead dirtyRead = new DirtyRead();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				dirtyRead.setValue("w5", "456");
			}});
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dirtyRead.getValue();
	}

}
