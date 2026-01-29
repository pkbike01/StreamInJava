package com.streamInJava;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperation {

	// Terminal operation: It helps us to produce the final result.
	// Intermediate operations (like map, filter) prepare the stream and lead to…

//Terminal operations (like forEach, collect) which actually execute the stream and give a result.

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 7, 3, 4, 8);

		// 1. collect
		list.stream().skip(1).collect(Collectors.toList());

		// 2. forEach
		list.stream().forEach(System.out::println);

//		list.stream().forEach(System.out::println);

		// 3. reduce : combines elements to produce a single result like sum of two
		// no.,multiply, subtract, etc...

		Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);

		System.out.println(reduce.get());

		// 4. count

		long count = list.stream().count();
		System.out.println(count);

		// 5. anyMatch, allMatch, noneMatch
		boolean anyMatch = list.stream().anyMatch(x -> x % 2 == 0);
		System.out.println(anyMatch);

		boolean allMatch = list.stream().allMatch(x -> x % 2 == 0);
		System.out.println(allMatch);

		boolean noneMatch = list.stream().noneMatch(x -> x % 2 == 0);
		System.out.println(noneMatch);

		boolean noneMatch2 = list.stream().noneMatch(x -> x > 99);
		System.out.println(noneMatch2);

		// 6. findFirst, findAny

		Integer integer = list.stream().findFirst().get();
		System.out.println(integer);

		Integer integer2 = list.stream().findAny().get();
		System.out.println(integer2);

		// example: find the name in the given list which length is greater than 4.
		List<String> asList = Arrays.asList("Pankaj", "raj", "ramesh", "rahul", "tina");

		List<String> collect = asList.stream().filter(x -> x.length() > 4).collect(Collectors.toList());
		System.out.println(collect);

		// ex 2: square the element in the given list and sort it in ascending order.

		List<Integer> asList2 = Arrays.asList(3, 6, 1, 7, 9, 3, 2);

		List<Integer> collect2 = asList2.stream().map(x -> x * x).sorted().distinct().collect(Collectors.toList());
		System.out.println(collect2);
		
		//most repeating character in a given string.
		//counting occurrence of character
		String str  = "pankaj";
		
		long count2 = str.chars().filter(x -> x =='a').count();

		System.out.println(count2);
		
		
		//stateful and stateless
		
		
		// Stateless operation:
		// The operation depends only on the current element, not on other elements.
		
		
		/*
		 * Why this is better:
		 * 
		 * “event” → element (correct term for streams)
		 * 
		 * Clear subject–verb structure
		 * 
		 * Sounds professional and interview-ready
		 */
		
//		Stateful operation:
			// The operation’s result depends on the current element as well as other elements.
		
			/*
			 * Example (Java Streams): stream.distinct(); // stateful (remembers seen
			 * elements) stream.sorted(); // stateful (needs all elements)
			 * 
			 * Quick comparison (easy to remember):
			 * 
			 * Stateless → works on one element at a time (map, filter)
			 * 
			 * Stateful → needs memory of other elements (distinct, sorted)
			 */
		
		
		
		
		
	}
}
