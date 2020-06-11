package com.bnpp.kata.game;

import java.util.Scanner;

import com.bnpp.kata.game.exception.InvalidArgumentsException;
import com.bnpp.kata.game.exception.PositionAlreadyOccupiedException;
import com.bnpp.kata.game.exception.PositionOutOfValidRangeException;
import com.bnpp.kata.game.model.Position;

public class TicTacToeGameRunner {
	private static final int COLUMN_INPUT = 1;
	private static final int ROW_INPUT = 0;
	private static final String GAME_CONTINUES = "Game Continues";

	public String playGame() throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		TicTacToeGame game = new TicTacToeGame();
		String result;
		Scanner scan = new Scanner(System.in);
		do {
			String[] input = scan.nextLine().split(",");
			result = game.play(new Position(Integer.parseInt(input[ROW_INPUT]), Integer.parseInt(input[COLUMN_INPUT])));
			game.gameBoard.printBoard();

		} while ((result.contains(GAME_CONTINUES) && scan.hasNext()));
		scan.close();
		return result;
	}

	public void validateUserInputs(String[] inputs) throws InvalidArgumentsException {
		boolean isInputValid = false;
		for (String input : inputs) {
			isInputValid = !input.isEmpty() && input.matches("\\d+");
			if (!isInputValid) {
				break;
			}
		}
		if (!isInputValid) {
			throw new InvalidArgumentsException(
					" Invalid inputs Passed :: Your inputs should be in the format of row comma column (for eg : 1,1) \n Kindly provide the inputs in expected format to continue the game");
		}
	}
}
