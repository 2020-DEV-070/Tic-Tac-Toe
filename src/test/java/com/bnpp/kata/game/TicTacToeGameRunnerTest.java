package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.bnpp.kata.game.exception.InvalidArgumentsException;

public class TicTacToeGameRunnerTest {

	private static final String[] INVALID_INPUT_MISSED_COLUMN = { "2" };
	private static final String[] INVALID_COORDINATES = { "1", "2", "1" };
	private static final String[] USER_INVALID_INPUT_EMPTY_ROW = { " ", "2" };
	private static final String USER_INPUT_ONE = "1,2";
	private static final String USER_INPUT_TWO = "1,1";
	private static final String USER_INPUT_THREE = "0,2";
	private static final String USER_INPUT_FOUR = "2,1";
	private static final String USER_INPUT_FIVE = "2,2";
	private static final String WINNER_RESULT = "X is the Winner!";
	private static final String NEW_LINE = System.getProperty("line.separator");

	TicTacToeGameRunner gameRunner;

	@Before
	public void initialize() {
		gameRunner = new TicTacToeGameRunner();
	}

	@Test
	public void shouldReturnTheGameResultBasedOnUserInputsWhenPlayGameMethodIsCalled() {
		StringBuilder inputStreamBuilder = new StringBuilder(USER_INPUT_ONE).append(NEW_LINE).append(USER_INPUT_TWO)
				.append(NEW_LINE).append(USER_INPUT_THREE).append(NEW_LINE).append(USER_INPUT_FOUR).append(NEW_LINE)
				.append(USER_INPUT_FIVE);
		System.setIn(new ByteArrayInputStream(inputStreamBuilder.toString().getBytes()));

		String gameResult = gameRunner.playGame();

		assertThat(gameResult, CoreMatchers.is(WINNER_RESULT));
	}

	@Test(expected = InvalidArgumentsException.class)
	public void shouldThrowInvalidArgumentsExceptionForInvalidInputsWhenEmptyRowIsPassedAsUserInput()
			throws InvalidArgumentsException {
		String[] invalidInputWithoutRow = USER_INVALID_INPUT_EMPTY_ROW;

		gameRunner.validateUserInputs(invalidInputWithoutRow);
	}

	@Test(expected = InvalidArgumentsException.class)
	public void shouldThrowInvalidArgumentsExceptionForInvalidExtraInputsOtherThanRowAndColumn()
			throws InvalidArgumentsException {
		String[] invalidInput = INVALID_COORDINATES;

		gameRunner.validateUserInputs(invalidInput);
	}

	@Test(expected = InvalidArgumentsException.class)
	public void shouldThrowInvalidArgumentsExceptionForInputsWithOnlyRowValue() throws InvalidArgumentsException {
		String[] invalidInput = INVALID_INPUT_MISSED_COLUMN;

		gameRunner.validateUserInputs(invalidInput);
	}
}
