package Utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

	@Test
	public void tc01() {
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		assertTrue(g.findUnconnectedNodes().size() == 4);
		assertTrue(g.findUnpointedToNodes().size() == 5);
		assertTrue(g.isTree() == false);
	}
	
	@Test
	public void tc02() {
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(3, 4);
		assertTrue(g.findUnconnectedNodes().size() == 1);
		assertTrue(g.findUnpointedToNodes().size() == 3);
		assertTrue(g.isTree() == false);
	}
	
	@Test
	public void tc03() {
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 6);
		g.addEdge(2, 5);
		assertTrue(g.findUnconnectedNodes().size() == 0);
		assertTrue(g.findUnpointedToNodes().size() == 1);
		assertTrue(g.isTree() == true);
	}
}
