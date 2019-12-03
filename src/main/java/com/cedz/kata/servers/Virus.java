package com.cedz.kata.servers;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Virus {

	private static final int ACTIVE = 1;

	
	public int breakout(List<List<Integer>> humans) {
	
		Map<Boolean, Set<Human>> infectionMap = new HashMap<> ();
		infectionMap.put(true, new HashSet<>());
		infectionMap.put(false, new HashSet<>());
		
		for (int row = 0 ; row < humans.size() ; row++) {
			List<Integer> rowList = humans.get(row);
			
			for(int column = 0; column < rowList.size();  column ++ ) {
				Human human = new Human(row, column);
				infectionMap.get(human.isActive(humans)).add(human);
			}
		}    	
		
		
		if( infectionMap.get(false).isEmpty()) {		
			return 0;
		}
		
		int longestInfectionTime = 0;
		for(Human cleanHuman : infectionMap.get(false)) {
			int infectionTime = Integer.MAX_VALUE;
			for(Human infectedHuman : infectionMap.get(true)) {
				int distance  = cleanHuman.distance(infectedHuman);
				
				if(distance < infectionTime) {
					infectionTime = distance;
				}
			}
			
			if(infectionTime > longestInfectionTime) {
				longestInfectionTime = infectionTime;
			}
		}
	
		return longestInfectionTime;
	}
	
	private static class Human {
		private Integer x;
		private Integer y;
		
	
		
		public Human(Integer x, Integer y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Integer getX() {
			return x;
		}

		public Integer getY() {
			return y;
		}

		public boolean isActive(List<List<Integer>> states) {
			return states.get(x).get(y) == ACTIVE;
		}
		
		
		public int distance (Human human) {
			return Math.abs(this.x - human.getX() ) +  Math.abs(this.y - human.getY() );
		}
		
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((x == null) ? 0 : x.hashCode());
			result = prime * result + ((y == null) ? 0 : y.hashCode());
			return result;
		}
		
		
		

		@Override
		public String toString() {
			return "Human [x=" + x + ", y=" + y + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Human other = (Human) obj;
			if (x == null) {
				if (other.x != null)
					return false;
			} else if (!x.equals(other.x))
				return false;
			if (y == null) {
				if (other.y != null)
					return false;
			} else if (!y.equals(other.y))
				return false;
			return true;
		}

	}
}
