/**
 * 
 */
package com.bagrouter.route.search;

import com.bagrouter.route.Node;
import com.bagrouter.route.search.NodePath;
import com.bagrouter.route.Edge;
import com.bagrouter.route.Graph;

/**
 * @author pras
 * @param <G>
 * @param <T>
 *
 */
public interface GraphSearchStrategy< T, G extends Graph<T, ? extends Edge<T>>> {

	NodePath<T> findPath( G graph, Node<T> startNode, Node<T> endNode );
}
