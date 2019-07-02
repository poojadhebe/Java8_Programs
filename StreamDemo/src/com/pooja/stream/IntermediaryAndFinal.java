package com.pooja.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class IntermediaryAndFinal {
	public static void main(String args[]) {
		List<String> list=new ArrayList<String>();
		Stream<String> stream1=Stream.of("one","two","three","four","five");
		stream1.peek(System.out::println).filter(p-> p.length()>3).peek(list::add); //Nothing will be printed
		System.out.println("list.size="+list.size()); //output 0 as all are intermediary operations and they are lazy to execute
		
		Stream<String> stream2=Stream.of("one","two","three","four","five");
		stream2.peek(System.out::println).filter(p-> p.length()>3).peek(list::add).forEach(System.out::println); //forEach is final or terminal operation
		System.out.println("list.size="+list.size());//outputs 3
	}
}
