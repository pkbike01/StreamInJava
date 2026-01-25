package com.streamInJava;

public class JavaStream {
	
	
	public static void main(String[] args) {
		
		//java 8 -> minimal code, functional programming
		//java 8 -> lambda expression, streams, data & time API
		
		
		
		//lambda expression
		//lambda expression is an anonymous function (no name, no return type, no access modifier)
		
		
		
		// lambda expression is used to implement functional interface;
		Thread t = new Thread(new JavaStream3());
		
		t.start();
		
		
		Thread t2 = new Thread( ()-> {
		// TODO Auto-generated method stub	
		
		System.out.println("Hello Buddy, How are You!!!");
		
	});
		
		
		t2.start();

		//Thread t3 = new Thread();

		
		MathOperation sumOperation = (int a, int b) ->  a + b;
		
		
		MathOperation subtractOperation = (int a, int b) ->  a - b;

		int sum = sumOperation.operate(3, 4);
		
		
		int subtract = subtractOperation.operate(5, 1);
		
		
		System.out.println(sum);
		System.out.println(subtract);
		
		
	}
	
	

}

class JavaStream3 implements Runnable{

	@Override
	public void run () {
		// TODO Auto-generated method stub
		
		
		System.out.println("Hello Buddy!!!");
		
	}
	
	
	

}


//To neglect this we implemented above code 
class  SumOperation implements MathOperation{

	@Override
	public int operate(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}	
}



interface MathOperation
{
	int operate(int a, int b);
	
	
	
}

