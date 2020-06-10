package com.bnpp.kata.game;

public class GameBoard {
	private static final int THREE = 3;
	private char[][] board;

	public GameBoard() {
		board = new char[THREE][THREE];
	}

	public char getPlayerAt(int row, int column) {
		return board[row][column];
	}

	public void addPlayerToBoard(int row, int column, char player) {
		board[row][column] = player;
	}
}