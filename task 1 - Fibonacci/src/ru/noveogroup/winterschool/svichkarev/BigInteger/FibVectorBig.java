package ru.noveogroup.winterschool.svichkarev.BigInteger;

import java.math.BigInteger;

public class FibVectorBig {
	// Result vector of Fibonacci sequence
	private BigInteger resFibN, resFibNplus1;
	private BigInteger tc;
	
	public FibVectorBig( int r1, int r2 ) {
		this.resFibN = BigInteger.valueOf( r1 );
		this.resFibNplus1 = BigInteger.valueOf( r2 );
	}
	
	public void mul( FibMatrixBig fm ) {
		tc = resFibN;
	    resFibN = resFibN.multiply( fm.getA11() ).add( resFibNplus1.multiply( fm.getA21() ) );
	    resFibNplus1 = tc.multiply( fm.getA12() ).add( resFibNplus1.multiply( fm.getA22() ) );
	}

	public BigInteger returnResult() {
		return resFibN;
	}
}
