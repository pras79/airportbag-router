package com.bagrouter.route.exception;

import com.bagrouter.route.exception.RoutingException;

public class SearchRouteException extends RoutingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SearchRouteException( String message ) { super(message); }
	public SearchRouteException( String message, Throwable t ) { super(message, t); }
}
