package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.bnpp.kata.game.model.Position;

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
		Position currentPosition = new Position(ZERO, ZERO);
		board.addPlayerToBoard(currentPosition);

		assertThat(board.getPlayerAt(currentPosition), CoreMatchers.is(PLAYER_X));
	}

	@Test
	public void playerShouldGetChangeAlternatively() {
		Position firstPosition = new Position(ZERO, ZERO);
		board.addPlayerToBoard(firstPosition);

		assertThat(board.getCurrentPlayer(), CoreMatchers.is(PLAYER_X));
		
		Position secondPosition = new Position(ONE, ONE);
		board.addPlayerToBoard(secondPosition);

		assertThat(board.getCurrentPlayer(), CoreMatchers.is(PLAYER_O));
	}
}
