package com.cedz.kata.tree

import spock.lang.Specification
import spock.lang.Unroll

class BFSSpec extends Specification {


  def "givenTreeNodes_whenDFS_thenShouldReturnCorrectResult" () {
    expect:
    ["1", "11", "12", "111","112", "1111"] == BFS.searchTree(createTree());

  }

  def Node createTree() {
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

    return node1
  }

  def "givenTreeNodes_whenDFSStack_thenShouldReturnCorrectResult" () {
    expect:
    ["1", "12", "11", "112","111", "1111"] == BFS.dfsInOrder(createTree());

  }
  @Unroll
  def "givenTreeNodes_whenSearchNode_thenShouldReturnCorrectResult" () {
    expect:
    result  == BFS.searchNode(createTree(), query);

    where:
    query         | result
    "6"           | null
    "1"           | new Node("1")
    "11"          | new Node("11")
    "12"          | new Node("12")
    "112"         | new Node("112")
    "111"         | new Node("111")
    "1111"        | new Node("1111")

  }

}
