package com.pooja.stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorExample {
	
	public static void main(String args[]) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(CollectorExample.class.getResourceAsStream("person.txt")))) {
			Stream<String> stream1=br.lines();
			List<Person> persons=new ArrayList<Person>();
			stream1.forEach(line->{
				String s[]=line.split(" ");
				Person p=new Person(s[0],Integer.parseInt(s[1]));
				persons.add(p);
			});
			System.out.println(persons);
			
			Optional<Person> minPerson=persons.stream().filter(p-> p.getAge()> 20).min(Comparator.comparing(Person::getAge));
			System.out.println("Youngest person > 20::"+minPerson);
			Map<Integer,Long> mapByAge=persons.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));
			System.out.println(mapByAge);
			Map<Integer,Set<String>> mapByAgeWithName=persons.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.toSet() )));
			System.out.println(mapByAgeWithName);
			Map<Integer,Set<String>> mapByAgeWithTreeSet=persons.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.toCollection(TreeSet::new) )));
			System.out.println(mapByAgeWithTreeSet);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
