package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class TicTacToeGameTest {

	@Test
	public void playerOneShouldBeAbleToPlaceXInAnyPositionAndRetrieveTheSame() {
		TicTacToeGame game = new TicTacToeGame();

		game.play(0, 0, 'X');

		assertThat(game.getPlayerAt(0, 0), CoreMatchers.is('X'));
	}

}
