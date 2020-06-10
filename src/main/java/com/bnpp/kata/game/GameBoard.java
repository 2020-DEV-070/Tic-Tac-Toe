package com.bnpp.kata.game;

public class GameBoard {
	private static final int THREE = 3;
	private char[][] board;
	private char currentPlayer;

	public GameBoard() {
		board = new char[THREE][THREE];
	}

	public char getPlayerAt(int row, int column) {
		return board[row][column];
	}

	public void addPlayerToBoard(int row, int column) {
		currentPlayer = getNextPlayer();
		board[row][column] = currentPlayer;
	}

	private char getNextPlayer() {
		if ('X' == currentPlayer) {
			return 'O';
		} else {
			return 'X';
		}
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}
}