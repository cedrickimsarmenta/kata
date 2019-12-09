package com.cedz.kata.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {

	private String name;
	private List<Node> children = new ArrayList<Node>();
	
	
	public Node(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public List<Node> getChildren() {
		return Collections.unmodifiableList(children);
	}
	
	public void addChild(Node node) {
		this.children.add(node);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Node [name=" + name + ", children=" + children + "]";
	}
	
}
