package com.example.marubatsudoroid;

public class ManualPlayer implements Player {
	String label;

	public ManualPlayer(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public int playTurn(String[] board) {
		return 0;
	}
}
