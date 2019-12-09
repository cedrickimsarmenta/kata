package com.cedz.kata.dfs;

import java.util.Arrays;
import java.util.List;

public class Graph {
	private List<Node> nodes;
	
	private int[][] adjacencyMatrix;

	public Graph(List<Node> nodes) {
		super();
		this.nodes = nodes;
		this.adjacencyMatrix = new int[nodes.size()][nodes.size()];
	}
	
	public Node getNodeByIndex(int index) {
		return nodes.get(index);
	}
	
	public void addAdjacency(int index1, int index2) {
		//For now, this is bidirectional tree
		adjacencyMatrix[index1][index2] = 1;
		adjacencyMatrix[index2][index1] = 1;
	}
	
	public boolean isAdjacent(int index1, int index2) {
		//For now, this is bidirectional tree
		return adjacencyMatrix[index1][index2] == 1;
	}
	public String render() {
		StringBuilder result = new StringBuilder();
		
		for(Node node : nodes) {
			result.append(node.getName());
			result.append(" ");
		}
		result.deleteCharAt(result.length() - 1);
		
		return result.toString();
	}


	@Override
	public String toString() {
		return "Graph [nodes=" + nodes + ", adjacencyMatrix=" + Arrays.toString(adjacencyMatrix) + "]";
	}
	
	
	public int size() {
		return this.nodes.size();
	}
	
	
}
