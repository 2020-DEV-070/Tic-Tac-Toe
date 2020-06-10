package com.bnpp.kata.game;

public class TicTacToeGame {
	private char[][] gameBoard = new char[3][3];

	public void play(int i, int j, char c) {
		gameBoard[i][j] = c;

	}

	public char getPlayerAt(int i, int j) {
		return gameBoard[i][j];
	}
}
