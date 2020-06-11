package com.bnpp.kata.game;

import java.util.logging.Logger;

import com.bnpp.kata.game.model.Player;
import com.bnpp.kata.game.model.Position;

public class GameBoard {
	private static final int MAX_TURNS_ALLOWED = 9;
	private static final int TWO = 2;
	private static final int ONE = 1;
	private static final int ZERO = 0;
	private static final int POSITION_LOWER_BOUND = ZERO;
	private static final int POSITION_UPPER_BOUND = TWO;
	private static final int THREE = 3;
	private char[][] board;
	private char currentPlayer;
	private int noOfPositionsOccupied = 0;

	private static final Logger LOGGER = Logger.getLogger(GameBoard.class.getName());

	public GameBoard() {
		board = new char[THREE][THREE];
	}

	public char getPlayerAt(Position currentPosition) {
		return board[currentPosition.getRow()][currentPosition.getColumn()];
	}

	public void addPlayerToBoard(Position currentPosition) {
		currentPlayer = getNextPlayer();
		board[currentPosition.getRow()][currentPosition.getColumn()] = currentPlayer;
		noOfPositionsOccupied++;
	}

	char getNextPlayer() {
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
		for (int row = ZERO; row < THREE; row++) {
			if (isBoardContentsAreSame(board[row][ZERO], board[row][ONE], board[row][TWO])) {
				return true;
			}
		}
		return false;
	}

	public boolean isAnyVerticalColumnsInBoardMarkedBySamePlayer() {
		for (int column = ZERO; column < THREE; column++) {
			if (isBoardContentsAreSame(board[ZERO][column], board[ONE][column], board[TWO][column])) {
				return true;
			}
		}
		return false;
	}

	private boolean isBoardContentsAreSame(char inputOne, char inputTwo, char inputThree) {
		return ((inputOne != Player.EMPTY.getValue()) && (inputOne == inputTwo) && (inputTwo == inputThree));
	}

	public boolean isLeftTopToRightBottomDiagonalPositionsAreMarkedBySamePlayer() {
		boolean isLeftDiagonalElementsAreEqual = true;
		int boardPositionToCompare = board[ZERO][ZERO];
		for (int row = ZERO; row < THREE; row++) {
			if (board[row][row] != boardPositionToCompare || isSelectedPositionEmpty(new Position(ZERO, ZERO))) {
				isLeftDiagonalElementsAreEqual = false;
				break;
			}
		}
		return isLeftDiagonalElementsAreEqual;
	}

	public boolean isRightTopToLeftBottomDiagonalPositionsAreMarkedBySamePlayer() {
		boolean isRightDiagonalElementsAreEqual = true;
		int length = board.length;
		int boardPositionToCompare = board[ZERO][length - ONE];
		for (int row = 0, column = length - ONE; row < length; row++, column--) {
			if (board[row][column] != boardPositionToCompare
					|| isSelectedPositionEmpty(new Position(ZERO, length - 1))) {
				isRightDiagonalElementsAreEqual = false;
				break;
			}
		}
		return isRightDiagonalElementsAreEqual;
	}

	public boolean isBoardFullyOccupied() {
		return noOfPositionsOccupied == MAX_TURNS_ALLOWED;
	}

	public void printBoard() {
		StringBuilder boardPrinter = new StringBuilder();
		boardPrinter.append("\n-------------\n");

		for (int row = ZERO; row < THREE; row++) {
			boardPrinter.append("| ");
			for (int column = ZERO; column < THREE; column++) {
				boardPrinter.append(board[row][column] + " | ");
			}
			boardPrinter.append("\n");
			boardPrinter.append("-------------\n");
		}

		String boardLayout = boardPrinter.toString();

		LOGGER.info(boardLayout);
	}
}