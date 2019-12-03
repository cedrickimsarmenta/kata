package com.cedz.kata.bowling;

public class Bowling {
	private static final int EMPTY = -1;
	private int[] scores = {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY};
	private int[] missingScores = {0,0,0,0,0,0,0,0,0,0};
	
	private int frame = 0;
	
	public void roll(int pins) {
		
		if(frame > 11) {
			return;
		}

		handlePrevious(frame - 1, pins);
		handlePrevious(frame - 2, pins);
		
		if(frame < scores.length) {
			handleCurrent(pins);
		} else {
			frame ++;
		}
		
		
	}
	
	
	private void handleCurrent(int pins) {

		boolean secondBall = scores[frame] != EMPTY;

		scores[frame] = scores[frame] == EMPTY ? 0 : scores[frame];
		
		if(frame < scores.length) {
			scores[frame]  += pins;
		}
				
		boolean isWipe = scores[frame] >= 10;

		handleStrikeOrSpare(secondBall, isWipe);
		
		if(secondBall || isWipe) {
			frame++;
		}
		
	}
	private void handleStrikeOrSpare(boolean secondBall, boolean isWipe) {
		if(isWipe) {
			if(!secondBall) {
				//a strike
				missingScores[frame] = 2;
			} else {
				//a spare
				missingScores[frame] = 1;
			}
		}
	}
	private void handlePrevious(int previousIndex, int pins) {
		if(previousIndex >= 0 && previousIndex < missingScores.length && missingScores[previousIndex] > 0) {
			scores[previousIndex] += pins; 
			missingScores[previousIndex] -= 1;
		}
	}
	
	public int getFrame() {
		return frame;
	}
	
	public int getScore() { 
		int sum = 0;
		for(int i = 0; i < 10; i++ ) {
			int score = scores[i];
			if(EMPTY == scores[i]) {
				continue;
			}
			sum += score;
		}
		return sum;
	}
}
