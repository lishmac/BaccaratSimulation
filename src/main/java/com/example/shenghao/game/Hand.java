package com.example.shenghao.game;

import java.util.LinkedList;
import java.util.List;

public class Hand {
	private static final int[] valueMap = new int[]{0,1,2,3,4,5,6,7,8,9,0,0,0,0};
	private static final int NUMBER_OF_CARD = 3;
	private int score;
	List<Card> cards;
	
	public Hand(){
		score = 0;
		cards = new LinkedList<Card>();
	}
	
	void addCard(Card incoming){
		cards.add(incoming);
	}
	
	private void calculate(){
		score = 0;
		for (int i=0; i<cards.size(); i++){
			score = score + valueMap[cards.get(i).getFaceValue()];
		}
		score = score % 10;
	}
	
	Integer valueOfCard(Card input){
		return valueMap[input.getFaceValue()];
	}
	
	public int getScore(){
		calculate();
		return score;
	}
}
