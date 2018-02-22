package com.cobee.threadspecial.chapter04;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 演示使用高性能的一个同步Map集合
 * @author Administrator
 *
 */
public class UseConcurrentHashMap {

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
//		ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<String, String>();
		
		map.put("k3", "value3");
		map.put("k1", "value1");
		map.put("k2", "value2");
		
		map.putIfAbsent("k3", "value33");

		for (Entry<String, String> entry : map.entrySet())
		{
			System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
		}
		
	}

}
