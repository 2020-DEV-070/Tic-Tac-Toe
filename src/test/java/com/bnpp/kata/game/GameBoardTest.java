package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class GameBoardTest {

	private static final char PLAYER_X = 'X';
	private static final int ZERO = 0;

	@Test
	public void playerShouldBeAbleToAddXInAnyPositionOfBoard() {
		GameBoard board = new GameBoard();

		board.addPlayerToBoard(ZERO, ZERO);

		assertThat(board.getPlayerAt(ZERO, ZERO), CoreMatchers.is(PLAYER_X));
	}

	@Test
	public void playerShouldGetChangeAlternatively() {
		GameBoard board = new GameBoard();

		board.addPlayerToBoard(ZERO, ZERO);

		assertThat(board.getCurrentPlayer(), CoreMatchers.is(PLAYER_X));

		board.addPlayerToBoard(1, 1);

		assertThat(board.getCurrentPlayer(), CoreMatchers.is('O'));
	}
}
