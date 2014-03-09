package ru.noveogroup.winterschool.svichkarev.BigInteger;

import java.math.BigInteger;

public class MatrixFibonacciBig implements FibonacciBig {
	@Override
	public BigInteger calcFibonacciNumber( int num ) throws ArithmeticException {
		if( num < 0 ){
			throw new ArithmeticException("illegal negative value: " + num);
		}
		
		// matrix for power
		FibMatrixBig fmTmp = new FibMatrixBig( 0, 1, 1, 1 );
		// vector for result
		FibVectorBig fvRes = new FibVectorBig( 0, 1 );
		
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
