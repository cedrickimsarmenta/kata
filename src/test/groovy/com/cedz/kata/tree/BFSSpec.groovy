package com.cedz.kata.tree

import spock.lang.Specification
import spock.lang.Unroll

class BFSSpec extends Specification {

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

    Node node112 = new Node("112");
    node11.addChild(node112);


    Node node1111 = new Node("1111");
    node111.addChild(node1111);
    expect:
    ["1", "11", "12", "111","112", "1111"] == BFS.searchTree(node1);

  }
}
