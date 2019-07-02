package com.pooja.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String args[]) {
		List<Integer> list1=Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> list2=Arrays.asList(1,2,3,4);
		List<Integer> list3=Arrays.asList(1,2,3);
		
		List<List<Integer>> list= Arrays.asList(list1,list2,list3);
		System.out.println(list);
		
		Function<List<?>,Integer> mapper=List::size;
		Function<List<Integer>,Stream<Integer>> flatmapper=l->l.stream();
		//using map
		System.out.println("Map:::");
		list.stream().map(mapper).forEach(System.out::println);
		System.out.println("Map 2:::");
		list.stream().map(flatmapper).forEach(System.out::println);
		//using flatmap
		System.out.println("Flat map:::");
		list.stream().flatMap(flatmapper).forEach(s->System.out.print(s+" "));
	}
}
