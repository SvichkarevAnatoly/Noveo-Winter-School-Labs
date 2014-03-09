package ru.noveogroup.winterschool.svichkarev.MatrixFibonacci;

public class FibVector {
	private int rc, rd;
	private int tc;
	
	public FibVector( int rc, int rd ) {
		this.rc = rc;
		this.rd = rd;
	}
	
	public void mul( FibMatrix fm ) {
		tc = rc;
	    rc = rc*fm.a11 + rd*fm.a21;
	    rd = tc*fm.a12 + rd*fm.a22;
	}

	public int returnResult() {
		return rc;
	}
}
