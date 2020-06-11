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

	@Test
	public void shouldValidateWhetherAnyVerticalColumnsInBoardAreMarkedBySamePlayer() {
		Position firstMove = new Position(ZERO, ZERO);
		Position secondMove = new Position(TWO, TWO);
		Position thirdMove = new Position(ONE, ZERO);
		Position fourthMove = new Position(ONE, TWO);
		Position fifthMove = new Position(TWO, ZERO);

		board.addPlayerToBoard(firstMove);
		board.addPlayerToBoard(secondMove);
		board.addPlayerToBoard(thirdMove);
		board.addPlayerToBoard(fourthMove);
		board.addPlayerToBoard(fifthMove);

		assertThat(board.isAnyVerticalColumnsInBoardMarkedBySamePlayer(), CoreMatchers.is(true));
	}

	@Test
	public void shouldReturnTrueWhenLeftTopToRightBottomDiagonalPositionsAreMarkedBySamePlayer() {
		Position firstMove = new Position(ZERO, ONE);
		Position secondMove = new Position(ZERO, ZERO);
		Position thirdMove = new Position(ONE, TWO);
		Position fourthMove = new Position(ONE, ONE);
		Position fifthMove = new Position(TWO, ONE);
		Position sixthMove = new Position(TWO, TWO);

		board.addPlayerToBoard(firstMove);
		board.addPlayerToBoard(secondMove);
		board.addPlayerToBoard(thirdMove);
		board.addPlayerToBoard(fourthMove);
		board.addPlayerToBoard(fifthMove);
		board.addPlayerToBoard(sixthMove);
		assertThat(board.isLeftTopToRightBottomDiagonalPositionsAreMarkedBySamePlayer(), CoreMatchers.is(true));
	}

	@Test
	public void shouldReturnTrueWhenRightTopToLeftBottomDiagonalPositionsAreMarkedBySamePlayer() {
		Position firstMove = new Position(ZERO, TWO);
		Position secondMove = new Position(ZERO, ZERO);
		Position thirdMove = new Position(ONE, ONE);
		Position fourthMove = new Position(ONE, TWO);
		Position fifthMove = new Position(TWO, ZERO);

		board.addPlayerToBoard(firstMove);
		board.addPlayerToBoard(secondMove);
		board.addPlayerToBoard(thirdMove);
		board.addPlayerToBoard(fourthMove);
		board.addPlayerToBoard(fifthMove);

		assertThat(board.isRightTopToLeftBottomDiagonalPositionsAreMarkedBySamePlayer(), CoreMatchers.is(true));
	}

	@Test
	public void shouldReturnTrueWhenAllThePositionsAreMarkedInABoard() {
		Position firstMove = new Position(ONE, ONE);
		Position secondMove = new Position(ZERO, TWO);
		Position thirdMove = new Position(ONE, TWO);
		Position fourthMove = new Position(ONE, ZERO);
		Position fifthMove = new Position(ZERO, ZERO);
		Position sixthMove = new Position(TWO, TWO);
		Position seventhMove = new Position(TWO, ONE);
		Position eighthMove = new Position(ZERO, ONE);
		Position lastMove = new Position(TWO, ZERO);

		board.addPlayerToBoard(firstMove);
		board.addPlayerToBoard(secondMove);
		board.addPlayerToBoard(thirdMove);
		board.addPlayerToBoard(fourthMove);
		board.addPlayerToBoard(fifthMove);
		board.addPlayerToBoard(sixthMove);
		board.addPlayerToBoard(seventhMove);
		board.addPlayerToBoard(eighthMove);
		board.addPlayerToBoard(lastMove);

		assertThat(board.isBoardFullyOccupied(), CoreMatchers.is(true));
	}

	@Test
	public void shouldBeAbleToPrintTheGameBoard() {
		Position firstMove = new Position(ONE, ONE);
		Position secondMove = new Position(ZERO, TWO);
		Position thirdMove = new Position(ONE, TWO);
		board.addPlayerToBoard(firstMove);
		board.addPlayerToBoard(secondMove);
		board.addPlayerToBoard(thirdMove);

		board.printBoard();
	}
}
