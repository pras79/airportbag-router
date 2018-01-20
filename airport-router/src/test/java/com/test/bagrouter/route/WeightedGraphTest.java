/**
 * 
 */
package com.test.bagrouter.route;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.bagrouter.route.Node;
import com.bagrouter.route.WeightedGraph;

/**
 * @author pras
 * @param <T>
 *
 */
public class WeightedGraphTest<T> {
	WeightedGraph<String> weightedGraph;
	
	@Before
	public void setUp(){
		weightedGraph = new WeightedGraph<>();
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testWeightedGraghNegativeWeight(){
		Node<String> firstNode = new Node<>( "A1" );
		Node<String> secondNode = new Node<>( "A1" );
		weightedGraph.addEdge(firstNode, secondNode, 0);
		
		fail();
	}

}
