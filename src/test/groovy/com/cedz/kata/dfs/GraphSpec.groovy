package com.cedz.kata.dfs;

import spock.lang.Specification;
import spock.lang.Unroll

public class GraphSpec extends Specification {
	
	@Unroll
	def "givenGraph_whenRender_thenShouldShowCorrectly" () {

		given:
		List<Node> graphNodes = new ArrayList<>();
		
		for (String node : nodes) {
			graphNodes.add( new Node(node));
		}
		
		
		Graph graph = new Graph(graphNodes)
	
		for(String adjacency : adjacencies) {
			String[] nodes = adjacency.split(":")
			int from = Integer.parseInt(nodes[0])
			int to = Integer.parseInt(nodes[1])
			
			graph.addAdjacency(from, to)
		}	   
		expect:
		expectedResult == graph.render();
	   
		where:
		nodes							| adjacencies			 	 ||		expectedResult
		["1"]                           | [] 				    	 ||      "1"
		["1", "2"]                      | []                   	  	 ||      "1 2"
		["1", "2"]                      | ["0:1"]                	 ||      "1-2"
			
	}
}
