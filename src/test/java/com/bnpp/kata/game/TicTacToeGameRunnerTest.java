package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.bnpp.kata.game.exception.PositionAlreadyOccupiedException;
import com.bnpp.kata.game.exception.PositionOutOfValidRangeException;

public class TicTacToeGameRunnerTest {

	@Test
	public void shouldReturnTheGameResultBasedOnUserInputsWhenPlayGameMethodIsCalled()
			throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		StringBuilder inputStreamBuilder = new StringBuilder("1,2").append("\n").append("1,1").append("\n")
				.append("0,2").append("\n").append("2,1").append("\n").append("2,2");
		System.setIn(new ByteArrayInputStream(inputStreamBuilder.toString().getBytes()));

		TicTacToeGameRunner gameRunner = new TicTacToeGameRunner();
		String gameResult = gameRunner.playGame();
		assertThat(gameResult, CoreMatchers.is("X is the Winner!"));
	}
}
