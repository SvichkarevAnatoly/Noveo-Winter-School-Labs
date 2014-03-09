package ru.noveogroup.winterschool.svichkarev.MatrixFibonacci;

public class FibMatrix {
	public int a11, a12,
			   a21, a22;
	private int tmpa11, tmpa12, tmpa21;
	
	public FibMatrix( int a11, int a12, int a21, int a22 ){
		this.a11 = a11;
		this.a12 = a12;
		this.a21 = a21;
		this.a22 = a22;
	}

	public void power2() {
		tmpa11 = a11;
		tmpa12 = a12;
		tmpa21 = a21;
		
	    a11 = a11*a11    	+ a12*a21;
	    a12 = tmpa11*a12 	+ a12*a22;
	    a21 = a21*tmpa11 	+ a22*a21;     
	    a22 = tmpa21*tmpa12 + a22*a22;
	}
}
