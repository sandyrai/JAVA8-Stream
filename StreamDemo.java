package com.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer>list=Arrays.asList(101,11,45,33,39,3,2,1,68,11,45,3);
		
		//sort the list in ascending order and display unique element
		System.out.println("sort the list in ascending order and display unique element");
		list.stream().sorted().distinct().forEach(System.out::println);
		
		//display the size of list
		System.out.println("\nDisplay the size of list");
		long size=list.stream().count();
		System.out.println(size);
		
		//display the total sum of list
		System.out.println("\nDisplay the total sum of list");
		int total=list.stream().reduce((a,b)->a+b).get();
		System.out.println(total);
		
		//dislpay max present number in list
		System.out.println("\nDislpay max present number in list");
		int max=list.stream().max(Comparator.comparingInt(Integer::valueOf)).get();
		System.out.println(max);
		
		
		//dislpay min present number in list
		System.out.println("\nDislpay min present number in list");
		int min=list.stream().min(Comparator.comparingInt(Integer::valueOf)).get();
		System.out.println(min);
		
		//Disply all the element starting with 3
		System.out.println("\nDisply all the element starting with 3");
		list.stream().map(x->String.valueOf(x)).filter(x->x.startsWith("3")).distinct().forEach(System.out::println);
		
		
		//Display second max element in list
		System.out.println("\nDisplay second max element in list");
		int secondMax=list.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secondMax);
		
		//Display all the duplicate element present in list
		System.out.println("\nDisplay all the duplicate element present in list");
		Set<Integer>dupSet=new HashSet<Integer>();
		Set<Integer>dupres=list.stream().filter(x ->!dupSet.add(x)).collect(Collectors.toSet());
		System.out.println(dupres);
	}

}
