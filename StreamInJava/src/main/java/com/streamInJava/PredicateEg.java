package com.streamInJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;




public class PredicateEg {
	
	
	//Predicate --> Functional interface (Boolean valued function)
	
	//It holds the condition;
	public static void main(String[] args) {
		
		
		Predicate<Integer> val = x -> x % 2 == 0;
		
		
		System.out.println(val.test(4)); // result : true
		
		
		Predicate<String> isWordStartingWithA = x -> x.toLowerCase().toString().startsWith("a");
		
		System.out.println(isWordStartingWithA.test("Aman"));  // for this : true
		
		System.out.println(isWordStartingWithA.test("Pankaj"));  ///for this : false
		
		
		
		Predicate<String> isWordEndsWithN = x -> x.toLowerCase().endsWith("n");
		
		Predicate<String> ConditionCheck = isWordStartingWithA.and(isWordEndsWithN);
		
		System.out.println("ConditionCheck for starts with and ends with : "+ConditionCheck.test("Aman"));
		
		
		//Function : It will do some work for you.
		
		Function<Integer, Integer> doubleIt = x -> x *2;  // R apply(T t);
		
//		System.out.println(doubleIt.apply(2));
		
		//andThen method
		//Compose method
		
		//identity method
		
		Function<Integer,Integer> tripleIt = x -> x * 3;
		System.out.println("Double of x : "+doubleIt.apply(2));
		
		System.out.println("Triple of x : "+tripleIt.apply(2));
		
		
		//andThen method
		System.out.println(doubleIt.andThen(tripleIt).apply(4));  //24
		
		
		System.out.println(tripleIt.andThen(doubleIt).apply(2));
		
		//compose method
		
		
		System.out.println(doubleIt.compose(tripleIt).apply(3));
		
		
		
		//Identity Method
		
		
		
		Function<Integer,Integer> iden = Function.identity();
		Integer res2 = iden.apply(5);
		System.out.println(res2);// It return the same value.
		
		
	
		//Consumer (Functional Interface)
		
		
		//ye bs lega, dega kuch nahi (bs jo lega wo use kr lega)
		
		
		
		Consumer<Integer> cons = x -> System.out.println(x);
		cons.accept(53);
		cons.accept(43);
		
		
		//andThen method
		
		List<Integer> lst = Arrays.asList(3,4,5,6,7);
		
		
		Consumer<List<Integer>> printList = x -> 
		{
			for(int i : x) 
			{
			
				System.out.println(i);
			}
		};
		
		System.out.println("print list : ");
		
		printList.accept(lst);
		
		
		//Supplier (It only supplies)
		
		Supplier<String> str = () -> "Hello";
		
		
		System.out.println(str.get());
		
		
		//Combined example for all
		
		
		Predicate<Integer> pr = x -> x % 2 ==0;
		
		Function<Integer,Integer> fn = x -> x *x ; 
		
		Consumer<Integer>  con = x -> System.out.println(x);
		
		Supplier<Integer> sup = () -> 100;
		
		
		if(pr.test(sup.get())) 
		{ //if this is true.
			
			con.accept(fn.apply(sup.get()));
		}
		
		
		
		//BiPredicate,BiConsumer,BiFunction (This will take two argument)
		
		
		BiPredicate<Integer,Integer> biPre = (x,y) -> (x+y) % 2 ==0;
		
		System.out.println(biPre.test(3, 5));
		
		
		BiConsumer<String,String> biCon = (x,y) -> {
			System.out.println(x +" "+y);
			
		};
		biCon.accept("abc", "defg");
		
		
		BiFunction<String,String,Integer> biFuc = (x,y) -> (x + y).length();
		Integer result = biFuc.apply("pankaj", "kumar");
		System.out.println(result);
		
		
		
		//UnaryOperator, BinaryOperator
		
		
		UnaryOperator<Integer> u = x -> 2 * x;
		BinaryOperator<Integer> biOp = (x,y) -> x + y ;
		
		
		Integer res3 = u.apply(4);
		System.out.println(res3);
		
		
		
		Integer res4 = biOp.apply(4, 2);
		System.out.println(res4);
		
		//32:07
		
		//method reference :  use method without invoking & in place of lambda expression
		
		List<String> name = Arrays.asList("ganshyam","ramesh","shayam","ram");
		
		
		name.forEach(x -> System.out.println(x) ); //replace lambda expression with method reference.
		
		//In this eg of method reference by using :: (Double colon)
		name.forEach(  System.out::println    ); 
		
		
		
		//constructor reference
		
		List<String> str3 = Arrays.asList("car","motor","bus","truck");
		
		//lambda approach
		List<AutoMobile> collect1 = str3.stream().map(x -> new AutoMobile(x) ).collect(Collectors.toList());
		
		System.out.println("collect1 : "+ collect1 );
		
		//by using constructor reference (AutoMobile :: new)  //new means constructor
		
		List<AutoMobile> collect2 = str3.stream().map( AutoMobile :: new ).collect(Collectors.toList());
		
		System.out.println("collect2 : "+ collect2);
		
	}
	
}


class AutoMobile{
	
	
	String name;

	public AutoMobile(String name) {
		super();
		this.name = name;
	}	
	
}