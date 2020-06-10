package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.bnpp.kata.game.model.Position;
import com.bnpp.kata.game.util.Player;

public class GameBoardTest {

	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;

	GameBoard board;

	@Before
	public void initialize() {
		board = new GameBoard();
	}

	@Test
	public void playerShouldBeAbleToAddXInAnyPositionOfBoard() {
		Position currentPosition = new Position(ZERO, ZERO);
		board.addPlayerToBoard(currentPosition);

		assertThat(board.getPlayerAt(currentPosition), CoreMatchers.is(Player.CROSS.getValue()));
	}

	@Test
	public void playerShouldGetChangeAlternatively() {
		Position firstPosition = new Position(ZERO, ZERO);
		board.addPlayerToBoard(firstPosition);

		assertThat(board.getCurrentPlayer(), CoreMatchers.is(Player.CROSS.getValue()));

		Position secondPosition = new Position(ONE, ONE);
		board.addPlayerToBoard(secondPosition);

		assertThat(board.getCurrentPlayer(), CoreMatchers.is(Player.NOUGHT.getValue()));
	}

	@Test
	public void shouldReturnTrueWhenSelectedPositionisEmptyAndNotOccupiedByAnyPlayer() {
		Position currentPosition = new Position(ZERO, ZERO);

		assertThat(board.isSelectedPositionEmpty(currentPosition), CoreMatchers.is(true));
	}

	@Test
	public void shouldReturnTrueWhenInputPositionValuesAreInValidRangeOf0To2() {
		Position validPosition = new Position(ZERO, ZERO);

		assertThat(board.isValidPositionRangeInBoard(validPosition), CoreMatchers.is(true));
	}

	@Test
	public void shouldValidateWhetherAnyHorizontalRowsInBoardAreMarkedBySamePlayer() {
		Position firstMove = new Position(ZERO, ZERO);
		Position secondMove = new Position(TWO, ONE);
		Position thirdMove = new Position(ZERO, ONE);
		Position fourthMove = new Position(ONE, TWO);
		Position fifthMove = new Position(ZERO, TWO);

		board.addPlayerToBoard(firstMove);
		board.addPlayerToBoard(secondMove);
		board.addPlayerToBoard(thirdMove);
		board.addPlayerToBoard(fourthMove);
		board.addPlayerToBoard(fifthMove);

		assertThat(board.isAnyHorizontalRowsInBoardMarkedBySamePlayer(), CoreMatchers.is(true));

	}
}
