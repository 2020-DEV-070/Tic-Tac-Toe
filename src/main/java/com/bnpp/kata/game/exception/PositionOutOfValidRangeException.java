package com.bnpp.kata.game.exception;

public class PositionOutOfValidRangeException extends Exception {
	private static final long serialVersionUID = 911638379698525138L;

	private final String errorMessage;

	public PositionOutOfValidRangeException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;
	}
}
