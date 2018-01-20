/**
 * 
 */
package com.bagrouter.parser.section;

/**
 * @author pras
 * Generic wrapper for a row of a given type specified
 */
public class SectionRowWrapper<T> {
	
	private T wrappedRow;

	public SectionRowWrapper( T wrappedRow ) {
		setWrappedRow( wrappedRow );
	}

	public T getWrappedRow() {
		return wrappedRow;
	}

	public void setWrappedRow(T wrappedRow) {
		this.wrappedRow = wrappedRow;
	}
}
