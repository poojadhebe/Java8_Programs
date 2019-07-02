package com.pooja.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {
	public static void main(String args[]) {
		Stream<String> stream1=Stream.of("one","two","three","four","five");
		//stream1.filter(s->s.length()>3).forEach(System.out::println);
		
		Predicate<String> p1=Predicate.isEqual("two");
		Predicate<String> p2=Predicate.isEqual("three");
		stream1.filter(p1.or(p2)).forEach(System.out::println);
		
		Stream<Integer> stream2=Stream.of(1,2,3,4,5,6);
		Predicate<Integer> p3=p-> p>3;
		stream2.filter(p3).forEach(System.out::println);
		
	}

}
