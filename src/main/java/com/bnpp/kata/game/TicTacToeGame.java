package com.bnpp.kata.game;

public class TicTacToeGame {
	private char[][] gameBoard = new char[3][3];

	public void play(int row, int column, char player) {
		gameBoard[row][column] = player;

	}

	public char getPlayerAt(int row, int column) {
		return gameBoard[row][column];
	}
}
