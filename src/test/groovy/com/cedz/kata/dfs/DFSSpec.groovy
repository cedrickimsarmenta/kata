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
//
//	 @Unroll
//	 def "givenGraphNodes_whenDFS_thenShouldReturnCorrectResult" () {
//
//		given:
//		Node node1 = new Node("1");
//		Node node11 = new Node("11");
//		node1.addChild(node11);
//	
//		Node node12 = new Node("12");
//		node1.addChild(node12);
//	
//		
//		Node node111 = new Node("111");
//		node11.addChild(node111);
//	
//		 expect:
//		 ["1", "11", "111", "12"] == DFS.searchTree(node1);
//		
//	 }
// 

}
