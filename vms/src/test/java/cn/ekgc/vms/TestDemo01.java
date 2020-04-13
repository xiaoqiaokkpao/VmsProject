package cn.ekgc.vms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestDemo01 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");

		Iterator iterator = set.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
