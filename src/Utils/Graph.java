package Utils;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int n;
	private boolean[][] edges;
	
	public Graph(int n) {
		this.n = n;
		this.edges = new boolean[n][n];
	}
	
	public void addEdge(int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= n || i == j)
			return;
		edges[i][j] = true;
	}
	
	public List<Integer> findUnconnectedNodes() {
		boolean[] connected = new boolean[n];
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				if (edges[i][j] == true) {
					connected[i] = true;
					connected[j] = true;
				}
		List<Integer> result =  new ArrayList<Integer>();
		for (int i = 0; i < n; ++i)
			if (!connected[i])
				result.add(i);
		return result;
	}
	
	public List<Integer> findUnpointedToNodes() {
		boolean[] pointedTo = new boolean[n];
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				if (edges[i][j] == true) {
					pointedTo[j] = true;
				}
		List<Integer> result =  new ArrayList<Integer>();
		for (int i = 0; i < n; ++i)
			if (!pointedTo[i])
				result.add(i);
		return result;
	}
	
	public boolean isTree() {
		List<Integer> unpointedToNodes = findUnpointedToNodes();
		if (unpointedToNodes.size() != 1)
			return false;
		int head = unpointedToNodes.get(0);
		boolean[] visited = new boolean[n];
		return DFS(head, visited);
	}
	
	private boolean DFS(int node, boolean[] visited) {
		if (visited[node] == true)
			return false;
		visited[node] = true;
		for (int i = 0; i < n; ++i) {
			if (edges[node][i] == false)
				continue;
			if (DFS(i, visited) == false)
				return false;
		}
		return true;
		
	}
}
