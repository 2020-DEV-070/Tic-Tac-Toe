package com.bnpp.kata.game.util;

public enum Player {
	CROSS('X'), NOUGHT('O');

	private char value;

	private Player(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}
}
