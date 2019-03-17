package com.cpg.frsdb.utility;

public class CustomAmountException extends Exception{
	
	public void CustomAmountException() {
		System.err.println("Deposit amount should be more than rent amount");
	}
}
