package com.bnpp.kata.game.exception;

public class InvalidArgumentsException extends Exception {
	private static final long serialVersionUID = 112325567260101798L;
	private final String errorMessage;

	public InvalidArgumentsException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;
	}
}