package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class GameBoardTest {

	private static final char PLAYER_X = 'X';
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final char PLAYER_O = 'O';

	GameBoard board;

	@Before
	public void initialize() {
		board = new GameBoard();
	}

	@Test
	public void playerShouldBeAbleToAddXInAnyPositionOfBoard() {
		board.addPlayerToBoard(ZERO, ZERO);

		assertThat(board.getPlayerAt(ZERO, ZERO), CoreMatchers.is(PLAYER_X));
	}

	@Test
	public void playerShouldGetChangeAlternatively() {
		board.addPlayerToBoard(ZERO, ZERO);

		assertThat(board.getCurrentPlayer(), CoreMatchers.is(PLAYER_X));

		board.addPlayerToBoard(ONE, ONE);

		assertThat(board.getCurrentPlayer(), CoreMatchers.is(PLAYER_O));
	}
}
