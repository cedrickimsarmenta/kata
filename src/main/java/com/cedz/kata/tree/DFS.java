package com.cedz.kata.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS {

	public static List<String> searchTree(Node node) {
		List<String> result = new ArrayList<String>();
		
		result.add(node.getName());
		
		for(Node child : node.getChildren() ) {
			result.addAll(searchTree(child));	
		}
		
		
		
		return result;
	}
	
	
	public static List<String> searchGraph(int startingNodeIndex, Graph graph) {

		List<String> result = new ArrayList<String>();
		
		Set<Integer> visited = new HashSet<>();
		searchGraph(startingNodeIndex, graph,visited, result);
		
		return result;
	}

	public static void searchGraph(int startingNodeIndex, Graph graph, Set<Integer> visited, List<String> result) {
		
		if(visited.contains(startingNodeIndex)) {
			return;
		}
		result.add(graph.getNodeByIndex(startingNodeIndex).getName());
		visited.add(startingNodeIndex);
		
		for(int j = 0; j<graph.size(); j ++) {
			if(startingNodeIndex !=j  && graph.isAdjacent(startingNodeIndex, j)) {
				searchGraph(j, graph,visited, result);
			}
		}
		
	}
}
