package ru.noveogroup.winterschool.svichkarev;
import java.math.BigInteger;

import ru.noveogroup.winterschool.svichkarev.BigInteger.FibonacciBig;
import ru.noveogroup.winterschool.svichkarev.BigInteger.MatrixFibonacciBig;
import ru.noveogroup.winterschool.svichkarev.MatrixFibonacci.MatrixFibonacci;

public class Main {
	public static void main(String[] args) {
		int arg = 46;
		
		Fibonacci fibRec = new RecursiveFibonacci();
		Fibonacci fibMatr = new MatrixFibonacci();
		
		FibonacciBig fibMatrBig = new MatrixFibonacciBig();
		
		int res;
		BigInteger resBig;
		
		long startTime;
        long endTime;
        long totalTime;
        
        if( arg <= 46 ){ // before the overflow of int
	        startTime = System.nanoTime();
	        res = fibRec.calcFibonacciNumber( arg );
	        endTime = System.nanoTime();
	        totalTime = endTime - startTime;
	        System.out.println("recursive : time = " + totalTime + "; res = " + res);
			
	    	startTime = System.nanoTime();
	    	res = fibMatr.calcFibonacciNumber( arg );
	    	endTime = System.nanoTime();
	    	totalTime = endTime - startTime;
	    	System.out.println("matrix    : time = " + totalTime + "; res = " + res );
        }
    	
    	startTime = System.nanoTime();
    	resBig = fibMatrBig.calcFibonacciNumber( arg );
    	endTime = System.nanoTime();
    	totalTime = endTime - startTime;
    	System.out.println("matrixBig : time = " + totalTime + "; res = " + resBig );
	}

}
