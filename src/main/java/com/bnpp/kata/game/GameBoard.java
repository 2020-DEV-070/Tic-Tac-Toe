package com.bnpp.kata.game;

import com.bnpp.kata.game.model.Position;

public class GameBoard {
	private static final int THREE = 3;
	private char[][] board;
	private char currentPlayer;

	public GameBoard() {
		board = new char[THREE][THREE];
	}

	public char getPlayerAt(Position currentPosition) {
		return board[currentPosition.getRow()][currentPosition.getColumn()];
	}

	public void addPlayerToBoard(Position currentPosition) {
		currentPlayer = getNextPlayer();
		board[currentPosition.getRow()][currentPosition.getColumn()] = currentPlayer;
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