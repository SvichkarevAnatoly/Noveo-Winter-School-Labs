package ru.noveogroup.winterschool.svichkarev.BigInteger;

import java.math.BigInteger;

public class FibVectorBig {
	// CR неговорящие названия
	private BigInteger rc, rd;
	private BigInteger tc;
	
	public FibVectorBig( int rc, int rd ) {
		this.rc = BigInteger.valueOf( rc );
		this.rd = BigInteger.valueOf( rd );
	}
	
	public void mul( FibMatrixBig fm ) {
		tc = rc;
	    rc = rc.multiply( fm.a11 ).add( rd.multiply( fm.a21 ) );
	    rd = tc.multiply( fm.a12 ).add( rd.multiply( fm.a22 ) );
	}

	public BigInteger returnResult() {
		return rc;
	}
}
