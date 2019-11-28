package com.cedz.kata.servers;

import spock.lang.Specification;
import spock.lang.Unroll;

public class VirusSpec extends Specification {
	  private Virus virus = new Virus();
	  
	  @Unroll
	  def "givenVirusDetails_whenComputeBreakout_thenShouldReturnCorrectResult" () {

		expect:
		expectedResult == virus.breakout(humans)
	    
		where:
	    humans                                    			 	            || expectedResult
        [[1],[1]]								 				            || 0
		[[1],[0]]								 				            || 1
		[[0,0],[0,1]]						    				            || 2
		[[0,0,0],[0,0,0],[0,0,1]]				 				            || 4
		[[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]				            || 6
		[[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,1]]  || 22
		[[0,0,0,0,0],[0,0,0,0,0],[0,0,1,0,0],[0,0,0,0,0],[0,0,0,0,0]]       ||  4
	  }

}

