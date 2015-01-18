package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int vertex;
	private boolean[][] neighbors;
	private int[][] weight;
	
	public Graph(int vertex) {
		this.vertex = vertex;
		this.neighbors = new boolean[vertex][vertex];
		this.weight = new int[vertex][vertex];
	}
	
	public int getNumVertex() {
		return this.vertex;
	}
	
	public void addEdge(int v1, int v2, int w) throws VertexIndexOverflowException{
		if (v1 < 0 || v2 < 0 || v1 >= vertex || v2 >= vertex || v1 == v2)
			throw new VertexIndexOverflowException();
		neighbors[v1][v2] = true;
		weight[v1][v2] = w;
	}
	
	public void addEdge(int v1, int v2) throws VertexIndexOverflowException {
		this.addEdge(v1, v2, 1);
	}
	
	public boolean isEdge(int v1, int v2) throws VertexIndexOverflowException {
		if (v1 < 0 || v2 < 0 || v1 >= vertex || v2 >= vertex || v1 == v2)
			throw new VertexIndexOverflowException();
		return neighbors[v1][v2];
	}
	
	public int getWeight(int v1, int v2) throws VertexIndexOverflowException {
		if (v1 < 0 || v2 < 0 || v1 >= vertex || v2 >= vertex || v1 == v2)
			throw new VertexIndexOverflowException();
		if (!neighbors[v1][v2])
			return 0;
		else
			return weight[v1][v2];
	}
	
	public List<Integer> getNeighbors(int v) {
		List<Integer> result = new ArrayList<Integer>();
		if (v < 0 || v >= this.getNumVertex())
			return result;
		for (int i = 0; i < getNumVertex(); ++i)
			if (neighbors[v][i])
				result.add(i);
		return result;
	}
}
