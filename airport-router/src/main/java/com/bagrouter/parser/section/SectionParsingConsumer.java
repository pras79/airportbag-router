/**
 * 
 */
package com.bagrouter.parser.section;

import com.bagrouter.parser.ParseException;

/**
 * @author pras
 *
 */
public interface SectionParsingConsumer <T extends SectionEntry> {
	
	void accept( T data ) throws ParseException;
}
