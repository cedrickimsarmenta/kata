package com.cedz.kata.dfs;

import spock.lang.Specification;
import spock.lang.Unroll;

public class DFSSpec extends Specification {
	
	
	 @Unroll
	 def "givenTreeNodes_whenDFS_thenShouldReturnCorrectResult" () {

		given:
		Node node1 = new Node("1");
		Node node11 = new Node("11");
		node1.addChild(node11);
	
		Node node12 = new Node("12");
		node1.addChild(node12);
	
		
		Node node111 = new Node("111");
		node11.addChild(node111);
	
	 	expect:
 		["1", "11", "111", "12"] == DFS.searchTree(node1);
		
	 }
	 @Unroll
	 def "givenGraph_whenDFS_thenShouldComputeCorrectly" () {
 
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
		 expectedResult == DFS.searchGraph(0, graph);
		
		 where:
		 nodes												| adjacencies			 	 												 ||		expectedResult
		 ["1"]                          					| []                	              									     ||     ["1"]
		 ["1", "2"]                                         | []                	     									             ||     ["1"]
		 ["1", "2"]                     					| ["0:1"]                	 											     ||     ["1", "2"]
		 ["A", "B","S","C","D", "E","F", "G", "H"]          | ["0:1","0:2","2:3","2:7","3:4","3:5","3:6","7:8","5:8", "6:7"]             ||     ["A", "B", "S", "C", "D", "E", "H", "G", "F"]
		                                                                                                                                          
	 }
	 
	 


}
