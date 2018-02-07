package com.fastscripts.model.business.exception;

public class PropertyFileNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public PropertyFileNotFoundException(final String message, final Throwable exception)
    {
        super(message, exception);
    }
}
