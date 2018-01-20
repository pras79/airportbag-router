/**
 * 
 */
package com.bagrouter.model;

/**
 * @author pras
 * @param <T>
 * An object that implements this should have an ID
 */
public interface Identifiable<T> {
	
	T getId();

}
