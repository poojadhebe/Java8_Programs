package com.pooja.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {
	
	public static void main(String args[]) {
		List<Integer> list=Arrays.asList(10,10,20);
		Integer redSum=list.stream().reduce(0, Integer::sum);
		System.out.println(redSum);
	//	Integer redMax=list.stream().reduce(0, Integer::max); //will print 0 for empty List which is wrong. There is no identity element for max
		Optional<Integer> redMax=list.stream().reduce(Integer::max);
		System.out.println(redMax);//will print Optional.empty for empty list
		
	}

}
