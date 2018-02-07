package com.fastscripts.model.services.exceptions;

public class InventoryException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InventoryException(final String exceptionMessage){
		super(exceptionMessage);
	}
	
	public InventoryException(final String exceptionMessage, final Throwable exceptionType){
		super(exceptionMessage, exceptionType);
	}
}
