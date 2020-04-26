package com.capgemini.SpringMVCJPADBDemo.Exceptions;

public class RecordNotFoundException extends Exception{

	public RecordNotFoundException(String exp) {
		exp="Record not found";
	}

}
