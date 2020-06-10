package com.bnpp.kata.game;

public class TicTacToeGame {
	private static final int THREE = 3;
	private char[][] gameBoard;

	public TicTacToeGame() {
		gameBoard = new char[THREE][THREE];
	}

	public void play(int row, int column, char player) {
		gameBoard[row][column] = player;

	}

	public char getPlayerAt(int row, int column) {
		return gameBoard[row][column];
	}
}
