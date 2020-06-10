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

	private static final String WINS_THE_GAME = " is the Winner!";
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

		assertThat(game.play(fifthMove), CoreMatchers.is(Player.CROSS.getValue() + WINS_THE_GAME));
	}

	@Test
	public void shouldDeclareWinnerWhenAnyOfTheVerticalColumnsAreMarkedBySamePlayer()
			throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		Position firstMove = new Position(ZERO, ZERO);
		game.play(firstMove);

		Position secondMove = new Position(TWO, TWO);
		game.play(secondMove);

		Position thirdMove = new Position(ONE, ZERO);
		game.play(thirdMove);

		Position fourthMove = new Position(ONE, TWO);
		game.play(fourthMove);

		Position fifthMove = new Position(TWO, ZERO);

		assertThat(game.play(fifthMove), CoreMatchers.is(Player.CROSS.getValue() + WINS_THE_GAME));
	}

	@Test
	public void shouldDeclareWinnerWhenLeftTopToRightBottomDiagonalPositionsAreMarkedBySamePlayer()
			throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		Position firstMove = new Position(ZERO, ONE);
		game.play(firstMove);

		Position secondMove = new Position(ZERO, ZERO);
		game.play(secondMove);

		Position thirdMove = new Position(ONE, TWO);
		game.play(thirdMove);

		Position fourthMove = new Position(ONE, ONE);
		game.play(fourthMove);

		Position fifthMove = new Position(TWO, ONE);
		game.play(fifthMove);

		Position sixthMove = new Position(TWO, TWO);

		assertThat(game.play(sixthMove), CoreMatchers.is(Player.NOUGHT.getValue() + WINS_THE_GAME));
	}

	@Test
	public void shouldDeclareWinnerWhenRightToptToLeftBottomDiagonalPositionsAreMarkedBySamePlayer()
			throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		Position firstMove = new Position(ZERO, TWO);
		game.play(firstMove);

		Position secondMove = new Position(ZERO, ZERO);
		game.play(secondMove);

		Position thirdMove = new Position(ONE, ONE);
		game.play(thirdMove);

		Position fourthMove = new Position(ONE, TWO);
		game.play(fourthMove);

		Position fifthMove = new Position(TWO, ZERO);

		assertThat(game.play(fifthMove), CoreMatchers.is(Player.CROSS.getValue() + WINS_THE_GAME));
	}

	@Test
	public void shouldDeclareGameIsDrawWhenAllThePositionsInBoardAreMarkedAndNoWinConditionsMet()
			throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		Position firstMove = new Position(ONE, ONE);
		game.play(firstMove);

		Position secondMove = new Position(ZERO, TWO);
		game.play(secondMove);

		Position thirdMove = new Position(ONE, TWO);
		game.play(thirdMove);

		Position fourthMove = new Position(ONE, ZERO);
		game.play(fourthMove);

		Position fifthMove = new Position(ZERO, ZERO);
		game.play(fifthMove);

		Position sixthMove = new Position(TWO, TWO);
		game.play(sixthMove);

		Position seventhMove = new Position(TWO, ONE);
		game.play(seventhMove);

		Position eighthMove = new Position(ZERO, ONE);
		game.play(eighthMove);

		Position lastMove = new Position(TWO, ZERO);

		assertThat(game.play(lastMove), CoreMatchers.is("Game is Draw"));
	}
}
