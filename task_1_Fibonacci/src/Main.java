public class Main {
	public static void main(String[] args) {		
		Fibonacci fib = new RecursiveFibonacci();
		System.out.println( fib.calcFibonacciNumber( 6 ) );
		
		try{
			System.out.println( fib.calcFibonacciNumber( -6 ) );
		}catch( Exception e ){
			System.out.println( "I catch it =)" );
		}
	}

}
