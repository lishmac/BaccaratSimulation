package com.example.shenghao.game;

public class Card {
	static enum Suit{
			Spade,
			Heart,
			Diamon,
			Club
	}
	private final int faceValue;
	private final Suit su;
	
	public Card(int faceValue, Suit s){
		this.faceValue = faceValue;
		this.su = s;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public Suit getSu() {
		return su;
	}
}
