package ru.noveogroup.winterschool.svichkarev.BigInteger;

import java.math.BigInteger;

public class FibMatrixBig {
	public BigInteger a11, a12,
					  a21, a22;
    // CR переменным достаточно быть локальными
	private BigInteger tmpa11, tmpa12, tmpa21;
	
	public FibMatrixBig( int a11, int a12, int a21, int a22 ){
		this.a11 = BigInteger.valueOf( a11 );
		this.a12 = BigInteger.valueOf( a12 );
		this.a21 = BigInteger.valueOf( a21 );
		this.a22 = BigInteger.valueOf( a22 );
	}

	public void power2() {
		tmpa11 = a11;
		tmpa12 = a12;
		tmpa21 = a21;
		
	    a11 = a11.multiply( a11 ).add( a12.multiply( a21 ) );
	    a12 = tmpa11.multiply( a12).add( a12.multiply( a22 ) );
	    a21 = a21.multiply( tmpa11 ).add( a22.multiply( a21 ) );     
	    a22 = tmpa21.multiply( tmpa12 ).add( a22.multiply( a22 ) );
	}
}
