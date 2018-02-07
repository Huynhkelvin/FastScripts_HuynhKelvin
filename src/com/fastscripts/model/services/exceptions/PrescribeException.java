package com.fastscripts.model.services.exceptions;

public class PrescribeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrescribeException(final String exceptionMessage){
		super(exceptionMessage);
	}
	
	public PrescribeException(final String exceptionMessage, final Throwable exceptionType){
		super(exceptionMessage, exceptionType);
	}
}
