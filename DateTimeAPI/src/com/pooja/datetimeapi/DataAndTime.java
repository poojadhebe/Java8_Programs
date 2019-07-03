package com.pooja.datetimeapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class DataAndTime {
	public static void main(String args[]){
		List<Person> persons=new ArrayList<Person>();
		try(BufferedReader br=new BufferedReader(new InputStreamReader(DataAndTime.class.getResourceAsStream("person.txt")));
				Stream<String> stream=br.lines();)
		{			
			stream.forEach(
					(line) ->{
				String s[]=line.split(" ");
				Person p=new Person(s[0],LocalDate.of(Integer.parseInt(s[3]), Month.of(Integer.parseInt(s[2])), Integer.parseInt(s[1])));
				persons.add(p);
				System.out.println(p);
			});
			
			LocalDate now=LocalDate.now();
			persons.stream().forEach(
					p->{
						Period period=Period.between(p.getDateOfBirth(),now);
						System.out.println(p.getName()+" was born "+period.get(ChronoUnit.YEARS) + 
								" and "+ period.get(ChronoUnit.MONTHS)+" months ago ["+p.getDateOfBirth().until(now,ChronoUnit.MONTHS)+"]");
					}
					);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
