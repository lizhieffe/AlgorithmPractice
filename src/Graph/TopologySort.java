package Graph;

import java.util.ArrayList;
import java.util.List;

public class TopologySort {
	private Graph graph;
	private boolean[] visited;
	
	public TopologySort(Graph g) {
		this.graph = g;
		this.visited = new boolean[g.getNumVertex()];
	}
	
	public List<Integer> sort() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < graph.getNumVertex(); ++i)
			if (!visited[i])
				sort(i, result);
		return result;
	}
	
	private void sort(int i, List<Integer> result) {
		visited[i] = true;
		List<Integer> neighbors = graph.getNeighbors(i);
		for (Integer neighbor : neighbors) {
			if (!visited[neighbor])
				sort(neighbor, result);
		}
		result.add(0, i);
	}
	
	
}
