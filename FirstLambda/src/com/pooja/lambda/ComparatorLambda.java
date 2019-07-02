package com.pooja.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {
	public static void main(String args[]) {
//		Comparator comp=new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return Integer.compare(o1.length(), o2.length());
//			}
//		};
		
		Comparator<String> lambdaComp=(String o1,String o2)-> Integer.compare(o1.length(), o2.length());
		
		List<String> arrList=Arrays.asList("**","***","*","****");
		Collections.sort(arrList, lambdaComp);
		for(String s:arrList)
		{
			System.out.println(s);
		}
	}

}
