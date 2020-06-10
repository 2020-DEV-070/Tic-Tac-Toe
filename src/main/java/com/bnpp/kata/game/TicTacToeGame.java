package com.bnpp.kata.game;

import com.bnpp.kata.game.model.Position;

public class TicTacToeGame {
	GameBoard gameBoard;

	public TicTacToeGame() {
		gameBoard = new GameBoard();
	}

	public char getPlayerAt(Position currentPosition) {
		return gameBoard.getPlayerAt(currentPosition);
	}

	public void play(Position currentPosition) {
		gameBoard.addPlayerToBoard(currentPosition);
	}
}
