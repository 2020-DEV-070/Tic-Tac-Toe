package com.bnpp.kata.game.model;

public enum Player {
	CROSS('X'), NOUGHT('O'), EMPTY('\0');

	private char value;

	Player(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}
}
