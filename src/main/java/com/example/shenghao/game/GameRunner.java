package com.example.shenghao.game;

import java.text.DecimalFormat;

import com.example.shenghao.game.BaccaratGame.RESULT;

public class GameRunner {
	public static void main(String[] args){		
		long bankerWin = 0;
		long playerWin = 0;
		long tie = 0;
		
		//run game 100 times
		int numOfRuns = 100000;
		for (int i=0; i<numOfRuns; i++){
			BaccaratGame currentGame = new BaccaratGame();
			RESULT currentR = currentGame.simulator();
			if (currentR.equals(RESULT.Tie)){
				tie++;
			}
			else if (currentR.equals(RESULT.Banker)){
				bankerWin++;
			}
			else {
				playerWin++;
			}
		}
		printResult(bankerWin, playerWin, tie);
	}
	
	private static void printResult(long bankerWin, long playerWin, long tie){
		long total = bankerWin + playerWin + tie;
		double bWin = (bankerWin+0.0)/total;
		double tieGame = (tie+0.0)/total;
		double pWin = (playerWin+0.0)/total;
		
		DecimalFormat x = new DecimalFormat("00.0%");
		
		System.out.println("banker wins: " + x.format(bWin));
		System.out.println("player wins: " + x.format(pWin));
		System.out.println("tie        : " + x.format(tieGame));
	}
}
