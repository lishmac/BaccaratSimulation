package com.example.shenghao.game;

public class BaccaratGame {
	private Shoe gameShoe;
	private Hand playerHand;
	private Hand bankerHand;
	
	enum RESULT{
		Banker,
		Tie,
		Player
    }
	
	BaccaratGame(){
		gameShoe = new Shoe(8);
		playerHand = new Hand();
		bankerHand = new Hand();
	}
	
	RESULT simulator(){
		//draw initial two hands
		playerHand.addCard(gameShoe.drawCard());
		bankerHand.addCard(gameShoe.drawCard());
		playerHand.addCard(gameShoe.drawCard());
		bankerHand.addCard(gameShoe.drawCard());
		
		//check natual
		int playerScore = playerHand.getScore();
		int bankerScore = bankerHand.getScore();
		
		if (playerScore >= 8 || bankerScore >= 8){
			if (playerScore == bankerScore){
				return RESULT.Tie;
			}
			
			return playerScore > bankerScore?RESULT.Player:RESULT.Banker;
		}
		
		//does player need a third card
		if (playerScore <= 5){
			Card playerThirdCard = gameShoe.drawCard();
			playerHand.addCard(playerThirdCard);
			int thirdCardValue = playerHand.valueOfCard(playerThirdCard);
			
			if (thirdCardValue == 9){
				thirdCardValue = -1;
			}
			else if (thirdCardValue == 8){
				thirdCardValue = -2;
			}
			
			thirdCardValue = thirdCardValue/2 + 3;
			
			if (bankerScore <= thirdCardValue){
				bankerHand.addCard(gameShoe.drawCard());
				bankerScore = bankerHand.getScore();
			}
			
			playerScore = playerHand.getScore();
		}
		else {
			if (bankerScore <= 5){
				bankerHand.addCard(gameShoe.drawCard());
			}
			bankerScore = bankerHand.getScore();
		}
		
		if (playerScore == bankerScore){
			return RESULT.Tie;
		}
		return playerScore < bankerScore?RESULT.Banker:RESULT.Player;
	}
	
	

}
