package com.fastscripts.model.services.exceptions;

public class PatientException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientException(final String exceptionMessage){
		super(exceptionMessage);
	}
	
	public PatientException(final String exceptionMessage, final Throwable exceptionType){
		super(exceptionMessage, exceptionType);
	}
}
