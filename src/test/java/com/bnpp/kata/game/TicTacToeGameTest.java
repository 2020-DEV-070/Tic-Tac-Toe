package com.bnpp.kata.game;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.bnpp.kata.game.model.Position;
import com.bnpp.kata.game.util.Player;

public class TicTacToeGameTest {

	private static final int ZERO = 0;

	@Test
	public void playerOneShouldBeAbleToPlaceXInAnyPositionAndRetrieveTheSame() {
		TicTacToeGame game = new TicTacToeGame();
		Position currentPosition = new Position(ZERO, ZERO);

		game.play(currentPosition);

		assertThat(game.getPlayerAt(currentPosition), CoreMatchers.is(Player.CROSS.getValue()));
	}

}
