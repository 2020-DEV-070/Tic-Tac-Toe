package com.bnpp.kata.game;

import java.util.Scanner;
import java.util.logging.Logger;

import com.bnpp.kata.game.exception.InvalidArgumentsException;
import com.bnpp.kata.game.exception.PositionAlreadyOccupiedException;
import com.bnpp.kata.game.exception.PositionOutOfValidRangeException;
import com.bnpp.kata.game.model.Position;

public class TicTacToeGameRunner {
	private static final String EXCEPTION_MSG = "Exception occured while playing the Game :::::: ";
	private static final String GAME_STARTS = "Game Starts";
	private static final int TWO = 2;
	private static final String INVALID_ARGUMENTS_MSG = " Invalid inputs Passed :: Your inputs should be in the format of row comma column (for eg : 1,1) \n Kindly provide the inputs in expected format to continue the game";
	private static final String EXPECTED_PATTERN = "\\d+";
	private static final int COLUMN_INPUT = 1;
	private static final int ROW_INPUT = 0;
	private static final String GAME_CONTINUES = "Game Continues";

	private static final Logger LOGGER = Logger.getLogger(TicTacToeGameRunner.class.getName());

	public static void main(String[] inputs) {
		TicTacToeGameRunner gameRunner = new TicTacToeGameRunner();
		String gameInstructions = gameRunner.displayGameInstructions();
		LOGGER.info(gameInstructions);

		String gameResult = gameRunner.playGame();
		LOGGER.info(gameResult);
	}

	public String playGame() {
		TicTacToeGame game = new TicTacToeGame();
		String result = GAME_STARTS;
		Scanner scan = new Scanner(System.in);
		do {
			String[] input = scan.nextLine().split(",");
			try {
				validateUserInputs(input);
				result = game
						.play(new Position(Integer.parseInt(input[ROW_INPUT]), Integer.parseInt(input[COLUMN_INPUT])));
				game.gameBoard.printBoard();
			} catch (PositionAlreadyOccupiedException | PositionOutOfValidRangeException
					| InvalidArgumentsException exception) {
				String exceptionMessage = EXCEPTION_MSG + exception.getMessage();
				LOGGER.severe(exceptionMessage);
			}

		} while (isGameContinues(result, scan));
		scan.close();
		return result;
	}

	private boolean isGameContinues(String result, Scanner scan) {
		return result.contains(GAME_CONTINUES) || (result.contains(GAME_STARTS)) && scan.hasNext();
	}

	public void validateUserInputs(String[] inputs) throws InvalidArgumentsException {
		boolean isInputValid = false;
		if (inputs.length == TWO) {
			for (String input : inputs) {
				isInputValid = !input.isEmpty() && input.matches(EXPECTED_PATTERN);
				if (!isInputValid) {
					break;
				}
			}
		}
		if (!isInputValid) {
			throw new InvalidArgumentsException(INVALID_ARGUMENTS_MSG);
		}
	}

	public String displayGameInstructions() {
		StringBuilder builder = new StringBuilder();

		builder.append("Welcome to Tic Tac Toe! \n");
		builder.append("Below are the rules for playing this game! \n");
		builder.append("X always goes first. \n");
		builder.append("Players cannot play on a played position\n");
		builder.append("Players alternate placing X’s and O’s on the board until either: \n");
		builder.append("One player has three in a row, horizontally, vertically or diagonally \n");
		builder.append("All nine squares are filled. \n");
		builder.append("If a player is able to draw three X’s or three O’s in a row, that player wins.\n");
		builder.append("If all nine squares are filled and neither player has three in a row, the game is a draw.\n");
		builder.append("Pass your inputs in commanline arguments in row and column fashion \n");
		builder.append(
				"Your inputs are in the format of row , column value for which the symbol to be placed in the game board");

		return builder.toString();
	}
}
