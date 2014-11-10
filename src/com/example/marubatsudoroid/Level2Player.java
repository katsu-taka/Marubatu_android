package com.example.marubatsudoroid;

import java.util.Random;

public class Level2Player extends MarubatsuBoard implements Player {
	String label;
	Random rand = new Random();

	// public Level2Player(String label, String[] board) {
	public Level2Player(String label) {
		this.label = label;
		// this.board = board;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public int playTurn(String[] board) {
		boolean flgLast = false; // 3つ揃った場合にtrueを設定
		int n = 0;
		int[][] checkLines = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
				{ 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };
		for (int[] is : checkLines) {
			if (label.equals(board[is[1]]) && label.equals(board[is[2]])
					&& board[is[0]].equals("")) {
				n = is[0];
				flgLast = true;
				break;
			} else if (label.equals(board[is[0]]) && label.equals(board[is[2]])
					&& board[is[1]].equals("")) {
				n = is[1];
				flgLast = true;
				break;
			} else if (label.equals(board[is[0]]) && label.equals(board[is[1]])
					&& board[is[2]].equals("")) {
				n = is[2];
				flgLast = true;
				break;
			}
		}
		if (flgLast == false) {
			boolean flgBlank = false;
			n = rand.nextInt(9);
			while (flgBlank == false) {
				n = rand.nextInt(9);
				flgBlank = isBlank(n, board);
			}
		}
		return n;
	}
}
