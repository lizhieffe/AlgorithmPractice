package Graph;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Dijsktra {
	private Graph graph;
	private boolean[] visited;
	private int[] distance;
	
	public Dijsktra(Graph g) {
		this.graph = g;
		visited = new boolean[graph.getNumVertex()];
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
			for (int i = 0; i < graph.getNumVertex(); ++i) {
				int minIndex = getMinIndex();
				visited[minIndex] = true;
				List<Integer> neighbors = graph.getNeighbors(minIndex);
				for (Integer neighbor : neighbors) {
					if (!visited[neighbor] 
							&& distance[minIndex] + graph.getWeight(minIndex, neighbor) 
							< distance[neighbor])
						distance[neighbor] = distance[minIndex] + graph.getWeight(minIndex, neighbor);
						
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
	
	private int getMinIndex() {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < graph.getNumVertex(); ++i) {
			if (!visited[i] && min > distance[i]) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}
}
