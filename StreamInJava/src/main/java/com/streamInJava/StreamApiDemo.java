package com.streamInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiDemo {

	public static void main(String[] args) {

		// 37:56

		// Feature introduced in java 8.

		// process collections of data in a functional and declarative manner.

		// simplify data processing

		// Embrace functional programming.

		// Improve Readability and maintainability

		// Enable Easy Parallelism

		// What is stream in java?
		// A sequence of elements supporting functional and declarative programming.
		// How to use Streams?
		// source,-> intermediate operations -> & terminal operation
		// we can convert any type of collection to stream.

		List<Integer> no = Arrays.asList(1, 2, 3, 4, 5, 6);

		Stream<Integer> strm = no.stream();

		List<Integer> reslt = new ArrayList<>();

		// find the even no by the traditional way and also find the count.

		int count = 0;

		for (int i = 0; i < no.size(); i++) {

			if (no.get(i) % 2 == 0) {
				
				count++;

				reslt.add(no.get(i));

			}

		}

		System.out.println(count);

		System.out.println(reslt);

		// System.out.println("By using stream : "+
		// strm.filter(x->x%2==0).collect(Collectors.toList()));
		// direct

		System.out.println("second one : ");
		
		System.out.println("count of even no: "+ no.stream().filter(x-> x % 2 == 0 ).count());

		strm.filter(x -> x % 2 == 0).collect(Collectors.toList()).forEach(System.out::println);
//		boolean allMatch = strm.allMatch(x -> x==3);

//		System.out.println(allMatch);
		
		
		
		// By using stream
		//creating stream
		
		
		//1. Form collections
		
		
		
		List<Integer> asList = Arrays.asList(1,2,3,4,5,6);
		
		
		Stream<Integer> strm1 = asList.stream();
		
//		2. From Arrays
		
		
		String[] array = {"a","b","c"};
		
		
		Stream<String> strm2 = Arrays.stream(array);
		
//		3. Using Stream.of();
		
		
		Stream<String> strm3 = Stream.of("a","b");
		System.out.println(strm3.collect(Collectors.toList()));
		
		//4. Infinite streams
		
		//By using generate and iterate, we can create infinite stream in java.
		
		Stream<Integer> str4 = Stream.generate(() -> 1);// generate infinite steam.
		
		
//		System.out.println(str4); 
		
		
		List<Integer> listOfNumbers = Stream.iterate(1, x -> x + 1).limit(100).collect(Collectors.toList());
		
		System.out.println(listOfNumbers);
		
		
		//47:57
//		rest in next class
		
		
		
		
		
		
		
		
		
		
		
		

	}

	
	
	

}
