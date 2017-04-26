package com.example.shenghao.game;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.shenghao.game.Hand;


public class HandTest {

	@Test
	public void test() {
		//test natual
		Hand naturalHand1 = new Hand();
		naturalHand1.addCard(new Card(5, Card.Suit.Club));
		naturalHand1.addCard(new Card(4, Card.Suit.Club));
		assertEquals(9, naturalHand1.getScore());
		
		Hand naturalHand2 = new Hand();
		naturalHand2.addCard(new Card(2, Card.Suit.Club));
		naturalHand2.addCard(new Card(6, Card.Suit.Club));
		assertEquals(8, naturalHand2.getScore());
		
		//test less 10
		Hand smallHand = new Hand();
		smallHand.addCard(new Card(1, Card.Suit.Club));
		smallHand.addCard(new Card(2, Card.Suit.Club));
		assertEquals(3, smallHand.getScore());
		
		//test more than 10
		Hand bigHand = new Hand();
		bigHand.addCard(new Card(8, Card.Suit.Club));
		bigHand.addCard(new Card(9, Card.Suit.Club));
		assertEquals(7, bigHand.getScore());
	}

}
