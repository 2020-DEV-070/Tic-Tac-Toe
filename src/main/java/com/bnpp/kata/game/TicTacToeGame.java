package com.bnpp.kata.game;

import com.bnpp.kata.game.exception.PositionAlreadyOccupiedException;
import com.bnpp.kata.game.exception.PositionOutOfValidRangeException;
import com.bnpp.kata.game.model.Position;

public class TicTacToeGame {
	private static final String GAME_IS_DRAW = "Game is Draw";
	private static final String GAME_CONTINUES = "Game Continues";
	private static final String WINS_THE_GAME = " is the Winner!";
	private static final String POSITION_OUT_OF_VALID_RANGE = "Input Position is out of range, Please select any valid position in the range of 0 to 2";
	private static final String INPUT_POSITION_NOT_EMPTY = "Selected position is not empty as it is already occupied by another player, Please select any other valid empty position";
	GameBoard gameBoard;

	public TicTacToeGame() {
		gameBoard = new GameBoard();
	}

	public char getPlayerAt(Position currentPosition) {
		return gameBoard.getPlayerAt(currentPosition);
	}

	public String play(Position currentPosition)
			throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		validateInputsToPlayFurther(currentPosition);
		gameBoard.markPlayerAt(currentPosition);

		String gameResult;

		if (isWinner()) {
			gameResult = getCurrentPlayer() + WINS_THE_GAME;
		} else if (isDraw()) {
			gameResult = GAME_IS_DRAW;
		} else {
			gameResult = GAME_CONTINUES;
		}
		return gameResult;
	}

	private boolean isDraw() {
		return gameBoard.isBoardFullyOccupied();
	}

	private boolean isWinner() {
		return gameBoard.isAnyHorizontalRowsInBoardMarkedBySamePlayer()
				|| gameBoard.isAnyVerticalColumnsInBoardMarkedBySamePlayer()
				|| gameBoard.isLeftTopToRightBottomDiagonalPositionsAreMarkedBySamePlayer()
				|| gameBoard.isRightTopToLeftBottomDiagonalPositionsAreMarkedBySamePlayer();
	}

	private char getCurrentPlayer() {
		return gameBoard.getCurrentPlayer();
	}

	private void validateInputsToPlayFurther(Position currentPosition)
			throws PositionOutOfValidRangeException, PositionAlreadyOccupiedException {
		if (!gameBoard.isValidPositionRangeInBoard(currentPosition)) {
			throw new PositionOutOfValidRangeException(POSITION_OUT_OF_VALID_RANGE);
		} else if (!gameBoard.isSelectedPositionEmpty(currentPosition)) {
			throw new PositionAlreadyOccupiedException(INPUT_POSITION_NOT_EMPTY);
		}
	}
}
