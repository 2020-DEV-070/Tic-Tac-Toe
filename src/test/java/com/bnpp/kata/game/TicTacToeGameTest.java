package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.bnpp.kata.game.exception.PositionAlreadyOccupiedException;
import com.bnpp.kata.game.model.Position;
import com.bnpp.kata.game.util.Player;

public class TicTacToeGameTest {

	private static final int ZERO = 0;
	TicTacToeGame game;

	@Before
	public void initialize() {
		game = new TicTacToeGame();
	}

	@Test
	public void playerOneShouldBeAbleToPlaceXInAnyPositionAndRetrieveTheSame() throws PositionAlreadyOccupiedException {
		Position currentPosition = new Position(ZERO, ZERO);

		game.play(currentPosition);

		assertThat(game.getPlayerAt(currentPosition), CoreMatchers.is(Player.CROSS.getValue()));
	}

	@Test(expected = PositionAlreadyOccupiedException.class)
	public void shouldThroughExceptionWhenPlayerTryToFillInNonEmptyPosition() throws PositionAlreadyOccupiedException {
		Position firstPosition = new Position(ZERO, ZERO);
		game.play(firstPosition);

		Position occupiedPosition = new Position(ZERO, ZERO);
		game.play(occupiedPosition);
	}

}
