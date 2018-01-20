/**
 * 
 */
package com.bagrouter.parser;

/**
 * @author pras
 * Generic Parsing Exception
 */
public class ParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ParseException( String message ) { super( message ); }
	public ParseException( String message, Throwable t ) { super( message, t ); }

}
