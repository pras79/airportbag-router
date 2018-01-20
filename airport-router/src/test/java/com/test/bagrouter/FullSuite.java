package com.test.bagrouter;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.test.bagrouter.parse.ParsingSuite;
import com.test.bagrouter.route.RouteTestSuite;

/**
 * Full test suite for the bagrouter project.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		ParsingSuite.class,
		RouteTestSuite.class,
})
public class FullSuite {}
