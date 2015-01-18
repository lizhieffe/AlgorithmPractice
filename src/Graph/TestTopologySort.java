package Graph;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TestTopologySort {

	@Test
	public void tc01() {
		Graph g = new Graph(6);
	    try {
			g.addEdge(5, 2);
			g.addEdge(5, 0);
		    g.addEdge(4, 0);
		    g.addEdge(4, 1);
		    g.addEdge(2, 3);
		    g.addEdge(3, 1);
		    TopologySort service = new TopologySort(g);
		    List<Integer> result = service.sort();
		    assertTrue(result.get(0) == 5);
		    assertTrue(result.get(1) == 4);
		    assertTrue(result.get(2) == 2);
		    assertTrue(result.get(3) == 3);
		    assertTrue(result.get(4) == 1);
		    assertTrue(result.get(5) == 0);
		} catch (VertexIndexOverflowException e) {
			e.printStackTrace();
		}
	    
	}
}
