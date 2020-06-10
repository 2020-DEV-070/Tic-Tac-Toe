package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.bnpp.kata.game.exception.PositionAlreadyOccupiedException;
import com.bnpp.kata.game.exception.PositionOutOfValidRangeException;
import com.bnpp.kata.game.model.Position;
import com.bnpp.kata.game.util.Player;

public class TicTacToeGameTest {

	private static final int THREE = 3;
	private static final int ZERO = 0;
	private static final int TWO = 2;
	private static final int ONE = 1;
	TicTacToeGame game;

	@Before
	public void initialize() {
		game = new TicTacToeGame();
	}

	@Test
	public void playerOneShouldBeAbleToPlaceXInAnyPositionAndRetrieveTheSame()
			throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		Position currentPosition = new Position(ZERO, ZERO);

		game.play(currentPosition);

		assertThat(game.getPlayerAt(currentPosition), CoreMatchers.is(Player.CROSS.getValue()));
	}

	@Test(expected = PositionAlreadyOccupiedException.class)
	public void shouldThroughExceptionWhenPlayerTryToFillInNonEmptyPosition()
			throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		Position firstPosition = new Position(ZERO, ZERO);
		game.play(firstPosition);

		Position occupiedPosition = new Position(ZERO, ZERO);
		game.play(occupiedPosition);
	}

	@Test(expected = PositionOutOfValidRangeException.class)
	public void shouldThroughExceptionWhenPlayerTryToFillInAPositionOutOfValidRange()
			throws PositionOutOfValidRangeException, PositionAlreadyOccupiedException {
		Position firstPosition = new Position(ZERO, ZERO);
		game.play(firstPosition);

		Position invalidPosition = new Position(THREE, THREE);
		game.play(invalidPosition);
	}

	@Test
	public void shouldDeclareWinnerWhenAnyOfTheHorizontalRowsAreMarkedBySamePlayer()
			throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		Position firstMove = new Position(ZERO, ZERO);
		game.play(firstMove);

		Position secondMove = new Position(TWO, ONE);
		game.play(secondMove);

		Position thirdMove = new Position(ZERO, ONE);
		game.play(thirdMove);

		Position fourthMove = new Position(ONE, TWO);
		game.play(fourthMove);

		Position fifthMove = new Position(ZERO, TWO);

		assertThat(game.play(fifthMove), CoreMatchers.is(Player.CROSS.getValue() + " is the Winner!"));
	}

}
