package com.capgemini.nodes;

public class NodeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6657851252382119341L;

	public NodeException() {
		super();
	}

	public NodeException(String message) {
		super(message);
	}

	public NodeException(Throwable throwable) {
		super(throwable);
	}

	public NodeException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public NodeException(String message, Throwable throwable, boolean bool1, boolean bool2) {
		super(message, throwable, bool1, bool2);
	}

}
