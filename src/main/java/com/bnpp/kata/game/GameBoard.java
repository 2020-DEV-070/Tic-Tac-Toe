package com.bnpp.kata.game;

import com.bnpp.kata.game.model.Position;
import com.bnpp.kata.game.util.Player;

public class GameBoard {
	private static final int POSITION_LOWER_BOUND = 0;
	private static final int POSITION_UPPER_BOUND = 2;
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

	public boolean isValidPositionRangeInBoard(Position validPosition) {
		return !(validPosition.getRow() > POSITION_UPPER_BOUND || validPosition.getRow() < POSITION_LOWER_BOUND
				|| validPosition.getColumn() > POSITION_UPPER_BOUND
				|| validPosition.getColumn() < POSITION_LOWER_BOUND);
	}

	public boolean isAnyHorizontalRowsInBoardMarkedBySamePlayer() {
		for (int row = 0; row < 3; row++) {
			if (isBoardContentsAreSame(board[row][0], board[row][1], board[row][2])) {
				return true;
			}
		}
		return false;
	}

	private boolean isBoardContentsAreSame(char boardPositionOneContent, char boardPositionTwoContent,
			char boardPositionThreeContent) {
		return ((boardPositionOneContent != '\0') && (boardPositionOneContent == boardPositionTwoContent)
				&& (boardPositionTwoContent == boardPositionThreeContent));
	}
}