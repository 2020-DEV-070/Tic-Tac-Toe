package com.bnpp.kata.game;

import com.bnpp.kata.game.exception.PositionAlreadyOccupiedException;
import com.bnpp.kata.game.exception.PositionOutOfValidRangeException;
import com.bnpp.kata.game.model.Position;

public class TicTacToeGame {
	private static final String INPUT_POSITION_NOT_EMPTY = "Selected position is not empty as it is already occupied by another player, Please select any other valid empty position";
	GameBoard gameBoard;

	public TicTacToeGame() {
		gameBoard = new GameBoard();
	}

	public char getPlayerAt(Position currentPosition) {
		return gameBoard.getPlayerAt(currentPosition);
	}

	public void play(Position currentPosition)
			throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		if (!gameBoard.isValidPositionRangeInBoard(currentPosition)) {
			throw new PositionOutOfValidRangeException(
					"Input Position is out of range, Please select any valid position in the range of 0 to 2");
		} else if (!gameBoard.isSelectedPositionEmpty(currentPosition)) {
			throw new PositionAlreadyOccupiedException(INPUT_POSITION_NOT_EMPTY);
		}
		gameBoard.addPlayerToBoard(currentPosition);
	}
}
