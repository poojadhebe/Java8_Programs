package com.pooja.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainOfConsumers {

	public static void main(String args[]) {
	List<String> arrList=Arrays.asList("one","two","three","four","five");
	List<String> result=new ArrayList<String>();
	//Way 1:
	Consumer<String> c1=s->{System.out.println(s);};
	arrList.forEach(c1);
	//Way 2:
	Consumer<String> c2=System.out::println;
	arrList.forEach(c2);
	
	//Add arrList elements to result arraylist
	Consumer<String> c3=result::add;
	arrList.forEach(c3);
	System.out.println("result.size="+result.size());
	
	//Chain of consumers
	List<String> result1=new ArrayList<>();
	Consumer<String> c4= result1::add;
	arrList.forEach(c2.andThen(c4));
	System.out.println("result1.size="+result1.size());

	//Chain of Consumers sequence
	List<String> list=Arrays.asList("pooja","vishal","shubham","pratu");
	Consumer<String> c5=System.out::println;
	Consumer<String> c6=s->System.out.println("Length of "+ s+"::"+s.length());
	list.forEach(c5.andThen(c6));
	
	}
}
