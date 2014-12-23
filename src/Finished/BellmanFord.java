package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class BellmanFord {
	int[] predecessor;
	int[] distance;
	
	public boolean bellmanFord(boolean[][] isNeighbor, int[][] weight, int beg) {
		if (isNeighbor == null || weight == null || isNeighbor.length == 0 || isNeighbor.length != weight.length || beg >= isNeighbor.length)
			return false;
		this.predecessor = new int[isNeighbor.length];
		this.distance = new int[isNeighbor.length];
		for (int i = 0; i < isNeighbor.length; i++)
			distance[i] = Integer.MAX_VALUE;
		distance[beg] = 0;
		int numVertex = 0;
		for (int i = 0; i < isNeighbor.length; i++) {
			for (int j = 0; j < isNeighbor.length; j++) {
				if (i != j && isNeighbor[i][j]) {
					numVertex++;
					break;
				}
			}
		}
		for (int i = 0; i < numVertex - 1; i++) {
			boolean foundRelax = false;
			for (int j = 0; j < isNeighbor.length; j++) {
				for (int k = 0; k < isNeighbor.length; k++) {
					if (needRelax(j, k, isNeighbor, weight, predecessor, distance)) {
						relax(j, k, isNeighbor, weight, predecessor, distance);
						foundRelax = true;
					}
				}
			}
			if (!foundRelax)
				return true;
		}
		for (int j = 0; j < isNeighbor.length; j++)
			for (int k = 0; k < isNeighbor.length; k++)
				if (needRelax(j, k, isNeighbor, weight, predecessor, distance))
					return false;
		return true;
	}
	
	private boolean needRelax(int i, int j, boolean[][] isNeighbor, int[][] weight, int[] predecessor, int[] distance) {
		if (!isNeighbor[i][j])
			return false;
		if (distance[j] > distance[i] + weight[i][j])
			return true;
		return false;
	}
	
	private void relax(int i, int j, boolean[][] isNeighbor, int[][] weight, int[] predecessor, int[] distance) {
		if (isNeighbor[i][j] && distance[j] > distance[i] + weight[i][j]) {
			predecessor[j] = i;
			distance[j] = distance[i] + weight[i][j];
		}
	}
	
	@Test
	public void test1() {
		boolean[][] isNeighbor = new boolean[5][5];
		isNeighbor[0][1] = true;
		isNeighbor[0][3] = true;
		isNeighbor[1][2] = true;
		isNeighbor[1][3] = true;
		isNeighbor[1][4] = true;
		isNeighbor[2][1] = true;
		isNeighbor[3][2] = true;
		isNeighbor[3][4] = true;
		isNeighbor[4][0] = true;
		isNeighbor[4][2] = true;
		
		int[][] weight = new int[5][5];
		weight[0][1] = 6;
		weight[0][3] = 7;
		weight[1][2] = 5;
		weight[1][3] = 8;
		weight[1][4] = -4;
		weight[2][1] = -2;
		weight[3][2] = -3;
		weight[3][4] = 9;
		weight[4][0] = 2;
		weight[4][2] = 7;
		
		BellmanFord testcase = new BellmanFord();
		boolean result = testcase.bellmanFord(isNeighbor, weight, 0);
		assertEquals("the given test cases has no negtive cycle", result, true);
		assertEquals("distance of #4 should equals -2", testcase.distance[4], -2);
		assertEquals("predecessor of #4 should be #1", testcase.predecessor[4], 1);
	}
}
