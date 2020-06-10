package com.bnpp.kata.game;

public class TicTacToeGame {
	GameBoard gameBoard;

	public TicTacToeGame() {
		gameBoard = new GameBoard();
	}

	public char getPlayerAt(int row, int column) {
		return gameBoard.getPlayerAt(row, column);
	}

	public void play(int row, int column, char player) {
		gameBoard.addPlayerToBoard(row, column, player);
	}
}
