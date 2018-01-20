package com.test.bagrouter.parse;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.test.bagrouter.parse.bag.BagEntryTest;
import com.test.bagrouter.parse.conveyor.ConveyorRouteTest;
import com.test.bagrouter.parse.departure.DepartureParserTest;
import com.test.bagrouter.parse.section.SectionHeaderTokenizerTest;
import com.test.bagrouter.parse.section.SectionTypeTest;

/**
 * Suite for parsing tests
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		DepartureParserTest.class,
		ConveyorRouteTest.class,
		BagEntryTest.class,
		SectionTypeTest.class,
		SectionHeaderTokenizerTest.class,
		
})
public class ParsingSuite {}
