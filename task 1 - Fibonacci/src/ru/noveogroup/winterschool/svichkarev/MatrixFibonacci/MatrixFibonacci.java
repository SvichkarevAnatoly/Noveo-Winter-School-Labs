package ru.noveogroup.winterschool.svichkarev.MatrixFibonacci;

import ru.noveogroup.winterschool.svichkarev.Fibonacci;

public class MatrixFibonacci implements Fibonacci {
	@Override
	public int calcFibonacciNumber( int num ) throws ArithmeticException {
		if( num < 0 ){
			throw new ArithmeticException("illegal negative value: " + num);
		}
		
		// matrix for power
		FibMatrix fmTmp = new FibMatrix( 0, 1, 1, 1 );
		// vector for result
		FibVector fvRes = new FibVector( 0, 1 );
		
		while( num != 0 ){
			// if power odd
			if( (num & 1) != 0 ){
				// multiply vector on matrix
				fvRes.mul( fmTmp );
			}
			
			// power two
			fmTmp.power2();
			
			num >>= 1;
		}
		
		return fvRes.returnResult();
	}
}
