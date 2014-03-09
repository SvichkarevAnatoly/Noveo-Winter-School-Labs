package ru.noveogroup.winterschool.svichkarev;


public final class RecursiveFibonacci implements Fibonacci {
	@Override
	public int calcFibonacciNumber(int num) throws ArithmeticException {
		if( num < 0 ){
			throw new ArithmeticException("illegal negative value: " + num);
		}
		
		switch( num ){
		case 0:
			return 0;
		case 1:
		case 2:
			return 1;
		default:
			return calcFibonacciNumber( num - 1 ) + calcFibonacciNumber( num - 2 );
		}
	}

}
