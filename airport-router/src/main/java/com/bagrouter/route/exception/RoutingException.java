package com.bagrouter.route.exception;

public class RoutingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6993887332671467365L;
	public RoutingException( String message ) { super(message); }
	public RoutingException( String message, Throwable t ) { super(message, t); }

}
