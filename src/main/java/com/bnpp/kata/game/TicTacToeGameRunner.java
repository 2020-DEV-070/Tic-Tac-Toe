package com.bnpp.kata.game;

import java.util.Scanner;

import com.bnpp.kata.game.exception.PositionAlreadyOccupiedException;
import com.bnpp.kata.game.exception.PositionOutOfValidRangeException;
import com.bnpp.kata.game.model.Position;

public class TicTacToeGameRunner {
	public String playGame() throws PositionAlreadyOccupiedException, PositionOutOfValidRangeException {
		TicTacToeGame game = new TicTacToeGame();
		String result;
		Scanner scan = new Scanner(System.in);
		do {
			String[] input = scan.nextLine().split(",");
			result = game.play(new Position(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
			game.gameBoard.printBoard();

		} while ((result.contains("Game Continues") && scan.hasNext()));
		scan.close();
		return result;
	}
}
