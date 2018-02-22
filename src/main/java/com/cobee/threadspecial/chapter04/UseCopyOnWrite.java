package com.cobee.threadspecial.chapter04;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UseCopyOnWrite {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> cowList = new  CopyOnWriteArrayList<String>();
		CopyOnWriteArraySet<String> cowSet = new CopyOnWriteArraySet<String>();
		
		cowList.add("cobee");
		cowList.add("jone");
		cowList.add("johny");
		cowList.add("cobee");
		
		System.out.println("cowList=" + cowList);
		
		cowSet.add("cobee");
		cowSet.add("jone");
		cowSet.add("johny");
		cowSet.add("cobee");
		
		System.out.println("cowSet=" + cowSet);
		
	}

}
