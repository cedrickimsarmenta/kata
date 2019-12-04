package com.cedz.kata.dfs;

import java.util.ArrayList;
import java.util.List;

public class DFS {

	public static List<String> searchTree(Node node) {
		List<String> result = new ArrayList<String>();
		
		result.add(node.getName());
		
		for(Node child : node.getChildren() ) {
			result.addAll(searchTree(child));	
		}
		
		
		
		return result;
	}
}
