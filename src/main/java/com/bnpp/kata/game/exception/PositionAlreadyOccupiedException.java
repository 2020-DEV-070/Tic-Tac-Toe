package com.bnpp.kata.game.exception;

public class PositionAlreadyOccupiedException extends Exception {
	private static final long serialVersionUID = 1582625567260101798L;
	private final String errorMessage;

	public PositionAlreadyOccupiedException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;
	}
}
