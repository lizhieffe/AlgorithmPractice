package Graph;

import java.util.List;

public class FindMaxDistance {
	private Graph graph;
	private int[] distance;
	
	public FindMaxDistance(Graph g) {
		this.graph = g;
		distance = new int[g.getNumVertex()];
		for (int i = 0; i < distance.length; ++i)
			distance[i] = 0;
	}
	
	public int findFromAnyStartVertex() {
		int result = Integer.MIN_VALUE;
		TopologySort service = new TopologySort(graph);
		List<Integer> topolgyOrder = service.sort();
		for (Integer vertice : topolgyOrder) {
			List<Integer> neighbors = graph.getNeighbors(vertice);
			for (Integer neighbor : neighbors) {
				try {
					if (distance[neighbor] < distance[vertice] 
							+ graph.getWeight(vertice, neighbor))
						distance[neighbor] = distance[vertice] 
								+ graph.getWeight(vertice, neighbor);
				} catch (VertexIndexOverflowException e) {
					e.printStackTrace();
				}
				if (distance[neighbor] > result)
					result = distance[neighbor];
			}
		}
		return result;
	}
}
