package com.test.bagrouter.route;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

import com.bagrouter.model.TerminalGate;
import com.bagrouter.parser.ParseException;
import com.bagrouter.parser.RoutingInput;
import com.bagrouter.parser.section.SectionParser;
import com.bagrouter.parser.section.SectionType;
import com.bagrouter.parser.section.conveyor.ConveyorRoute;
import com.bagrouter.parser.section.conveyor.ConveyorRowParser;
import com.bagrouter.route.Node;
import com.bagrouter.route.WeightedEdge;


public class WeightedEdgeTest {

	private Node<TerminalGate> node1 = new Node<>( new TerminalGate( "A1" ) );
	private Node<TerminalGate> node2 = new Node<>( new TerminalGate( "A2" ) );

	@Test (expected = FileNotFoundException.class)
	public void testCreateEdges() throws ParseException, FileNotFoundException {
		SectionParser parser = new SectionParser ();
				parser.setSectionInput( new RoutingInput(new FileInputStream( new File( "routing-input.txt" ))) );
		parser.addSectionConsumer( SectionType.CONVEYOR_SYSTEM, new ConveyorRowParser(), entry -> {
			ConveyorRoute conveyor = (ConveyorRoute)entry;
			Node<TerminalGate> node1 = new Node<>( conveyor.getFirstTerminal() );
			Node<TerminalGate> node2 = new Node<>( conveyor.getSecondTerminal() );
			WeightedEdge<TerminalGate> gateLink = new WeightedEdge<>( node1, node2, conveyor.getTravelTime() );

			assertNotNull( gateLink.getFirstNode() );
			assertNotNull( gateLink.getSecondNode() );
			assertNotEquals( gateLink.getWeight(), 0 );

			assertEquals( gateLink.getFirstNode().getNodeItem(), conveyor.getFirstTerminal() );
			assertEquals( gateLink.getSecondNode().getNodeItem(), conveyor.getSecondTerminal() );
		});
	}

	@Test (expected = IllegalArgumentException.class)
	public void testNegativeWeight() {
		new WeightedEdge<>( node1, node2, -1 );
		fail();
	}

	@Test (expected = IllegalArgumentException.class)
	public void testNullNode1() {
		new WeightedEdge<>( null, node2, -1 );
	}

	@Test (expected = IllegalArgumentException.class)
	public void testNullNode2() {
		new WeightedEdge<>( node1, null, -1 );
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEqualNode() {
		Node<String> node1 = new Node<>( "A1" );
		Node<String> node2 = new Node<>( "A1" );
		new WeightedEdge<>( node1, node2, 1 );
	}

	@Test
	public void equalsCheck() {
		Node<String> node1 = new Node<>( "A1" );
		Node<String> node2 = new Node<>( "A2" );
		WeightedEdge<String> link1 = new WeightedEdge<>( node1, node2, 2 );
		WeightedEdge<String> link2 = new WeightedEdge<>( node2, node1, 2 );
		WeightedEdge<String> link3 = new WeightedEdge<>( node1, node2, 2 );

		assertEquals( link1, link3 );
		assertEquals( link1, link2 );
		assertEquals( link2, link3 );

		assertEquals( link1.compareTo( link2 ), 0 );
		assertEquals( link1.compareTo( link3 ), 0 );
		assertEquals( link1.compareTo( new WeightedEdge<>( node1, node2, 3 ) ), -1 );
	}

	@Test
	public void compareCheck() {
		Node<String> node1 = new Node<>( "A1" );
		Node<String> node2 = new Node<>( "A2" );
		WeightedEdge<String> link1 = new WeightedEdge<>( node1, node2, 2 );
		WeightedEdge<String> link2 = new WeightedEdge<>( node2, node1, 2 );
		WeightedEdge<String> link3 = new WeightedEdge<>( node1, node2, 2 );
		assertEquals( link1.compareTo( link2 ), 0 );
		assertEquals( link1.compareTo( link3 ), 0 );
		assertEquals( link2.compareTo( link3 ), 0 );
		assertEquals( link1.compareTo( new WeightedEdge<>( node1, node2, 4 ) ), -1 );
	}

	@Test
	public void otherNodeCheck() {
		Node<String> node1 = new Node<>( "A1" );
		Node<String> node2 = new Node<>( "A2" );
		WeightedEdge<String> link1 = new WeightedEdge<>( node1, node2, 2 );
		WeightedEdge<String> link2 = new WeightedEdge<>( node2, node1, 2 );
		assertEquals( link1.getOtherNode( node2 ), node1 );
		assertEquals( link2.getOtherNode( node1 ), node2 );
	}

}
