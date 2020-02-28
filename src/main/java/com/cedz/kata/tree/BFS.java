package com.cedz.kata.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFS {

  public static List<String> dfsInOrder(Node p) {
    Stack<String> result = new Stack<>();
    Stack<Node> nodes = new Stack<>();
    nodes.add(p);
    searchTree(nodes, result);

    return result;
  }


  public static void searchTree(Stack<Node> nodes, Stack<String> result) {
    if(nodes.isEmpty()) {
      return;
    }
    Node p = nodes.pop();
    result.add(p.getName());

    for (Node child: p.getChildren()) {
      nodes.add(child);
    }
    searchTree(nodes, result);
  }







  public static List<String> searchTree(Node p) {
    Stack<String> result = new Stack<>();
    Queue<Node> nodes = new LinkedList<>();
    nodes.add(p);
    searchTree(nodes, result);

    return result;
  }

  public static void searchTree(Queue<Node> nodes, Stack<String> result) {
      if(nodes.isEmpty()) {
        return;
      }
      Node p =  nodes.poll();
      result.add(p.getName());

      for (Node child: p.getChildren()) {
        nodes.add(child);
      }
      searchTree(nodes, result);
  }
}
