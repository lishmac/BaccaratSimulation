package com.example.shenghao.game;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.example.shenghao.game.Card.Suit;

public class Shoe {
	private static final int NUMBER_OF_CARD = 416;
	//int topOfShoe = NUMBER_OF_CARD - 1;
	List<Card> cards;
	
	public Shoe(int numberOfDecks) {
		cards = new LinkedList<Card>();
		for (int i=0; i<numberOfDecks; i++){
			for (int j=1; j<=13; j++){
				for (Suit s: Suit.values()){
					cards.add(new Card(j, s));
				}
			}
		}
		
		shuffle();
	}
	
	private void shuffle(){
		Collections.shuffle(cards);
	}
	
	public Card drawCard(){
		if (cards.isEmpty()){
			return null;
		}
		
		return cards.remove(0);
	}
}
