package Graph;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BellmanFord {

	private Graph graph;
	private int[] distance;
	
	public BellmanFord(Graph g) {
		this.graph = g;
		distance = new int[graph.getNumVertex()];
		for (int i = 0; i < graph.getNumVertex(); ++i)
			distance[i] = Integer.MAX_VALUE;
	}
	
	public Map<Integer, Integer> findMinDistanceFrom(int index) {
		Map<Integer, Integer> result = new TreeMap<Integer, Integer>();
		if (index > graph.getNumVertex())
			return result;
		distance[index] = 0;
		try {
			for (int i = 0; i < graph.getNumVertex() - 1; ++i) {
				for (int j = 0; j < graph.getNumVertex(); ++j) {
					List<Integer> neighbors = graph.getNeighbors(j);
					for (Integer neighbor : neighbors) {
						if (distance[index] + graph.getWeight(index, neighbor) 
								< distance[neighbor])
							distance[neighbor] 
									= distance[index] + graph.getWeight(index, neighbor);
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < graph.getNumVertex(); ++i)
			result.put(i, distance[i]);
		return result;
	}

}
