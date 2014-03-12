package ru.noveogroup.winterschool.svichkarev.MatrixFibonacci;

public class FibVector {
	// Result vector of Fibonacci sequence
	private int resFibN, resFibNplus1;
	private int tc;
	
	public FibVector( int r1, int r2 ) {
		this.resFibN = r1;
		this.resFibNplus1 = r2;
	}
	
	public void mul( FibMatrix fm ) {
		tc = resFibN;
		resFibN = resFibN*fm.getA11() + resFibNplus1*fm.getA21();
		resFibNplus1 = tc*fm.getA12() + resFibNplus1*fm.getA22();
	}

	public int returnResult() {
		return resFibN;
	}
}
