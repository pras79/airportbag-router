package com.bagrouter.route;

public interface Edge<T> {
	
	Node <T> getFirstNode();
	Node <T> getSecondNode();
	Node<T> getOtherNode( Node<T> thisNode);
}
