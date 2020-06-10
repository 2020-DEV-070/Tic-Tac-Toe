package com.bnpp.kata.game;

import com.bnpp.kata.game.model.Position;
import com.bnpp.kata.game.util.Player;

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
		return Player.CROSS.getValue() == currentPlayer ? Player.NOUGHT.getValue() : Player.CROSS.getValue();
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean isSelectedPositionEmpty(Position currentPosition) {
		return board[currentPosition.getRow()][currentPosition.getColumn()] == Player.EMPTY.getValue();
	}
}