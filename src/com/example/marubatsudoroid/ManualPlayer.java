package com.example.marubatsudoroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			String line = reader.readLine();
			if (line.equals("r")) {
				return -9;
			}
			int value = Integer.parseInt(line);
			if (value < 0 || 8 < value) {
				return -1;
			}
			return value;
		} catch (IOException ioe) {
			return -1;
		} catch (NumberFormatException nfe) {
			return -1;
		}
	}
}
