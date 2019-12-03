package com.cedz.kata.bowling;

import spock.lang.Specification
import spock.lang.Unroll

public class BowlingSpec extends Specification {
	private Bowling bowling = new Bowling();
	
	
	@Unroll
	def "givenBowlingRolls_whenRolled_thenShouldComputeScoreAndFrame" () {
		
		expect:
		for(int i=0; i < rolls.size() ; i ++) {
			bowling.roll(rolls[i])
			def data =  frameScores[i]
			assert bowling.getScore() == data.s
			assert bowling.getFrame() == data.f
			
		}
		
		where:
		rolls													||				frameScores
		[0,0,4,5,9,1,10,4,3]								    ||              [[s:0, f:0],[s:0, f:1],[s:4, f:1],[s:9, f:2],[s:18, f:2],[s:19, f:3],[s:39, f:4],[s:47, f:4],[s:53, f:5]]
		[10,10,10,10,10,10,10,10,10,10,10,10]  				    ||              [[s:10, f:1], [s:30, f:2], [s:60, f:3], [s:90, f:4], [s:120, f:5], [s:150, f:6], [s:180, f:7], [s:210, f:8], [s:240, f:9], [s:270, f:10], [s:290, f:11], [s:300, f:12]]
	}
	
}
