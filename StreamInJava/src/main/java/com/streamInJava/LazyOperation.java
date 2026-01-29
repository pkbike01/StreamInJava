package com.streamInJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyOperation {
	public static void main(String[] args) {
		List<String> names =  Arrays.asList("alice","bob","charlie","David");
		
		
		Stream<String> fltrName = names.stream().filter(e -> {
			System.out.println("Filtering : "+e);
			return e.length()>3;
		});
		
		
		System.out.println("Before terminal Operation...");
		
		
		List<String> rs = fltrName.collect(Collectors.toList());
		
		System.out.println("After terminal Operation...");
		
		
		System.out.println(rs);
		
		
	}
	
	

}
