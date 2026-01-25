package com.streamInJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperation {

	// Intermediate Operations transform a stream into another stream.

	// They are lazy, meaning they don't execute until a terminal operation is
	// invoked.

	public static void main(String[] args) {

		System.out.println("Hello, Now It's time to begin...");
		//
//		1. filter
		List<String> list = Arrays.asList("pankaj", "raj", "aman", "naman", "anuj");

		Stream<String> filtered = list.stream().filter(x -> x.toLowerCase().startsWith("a"));

		// no filtering at this point

		long count = list.stream().filter(x -> x.toLowerCase().startsWith("a")).count();
		System.out.println(count);

//		2. map

		Stream<String> map = list.stream().map(String::toUpperCase);
		System.out.println(map.collect(Collectors.toList()));// collect is a termination operation.

//		3. sorted

		Stream<String> sorted = list.stream().sorted();

		Stream<String> sortedStreamUsingComparator = list.stream().sorted((a, b) -> a.length() - b.length());

//		4. distinct
		long count2 = list.stream().filter(x -> x.toLowerCase().startsWith("a")).distinct().count();
		System.out.println(count2);

//		5. limit 
		Stream<String> collectiveResult = list.stream().filter(x -> x.toLowerCase().endsWith("j")).limit(2);

		collectiveResult.forEach(System.out::print);
		System.out.println();
//	    6. skip
		System.out
				.println(list.stream().skip(1).filter(x -> x.toLowerCase().endsWith("j")).collect(Collectors.toList()));
		System.out.println(Stream.iterate(1, x -> x + 1).limit(100).collect(Collectors.toList()));

		System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).collect(Collectors.toList()));

		System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count());
		;
	}
}
