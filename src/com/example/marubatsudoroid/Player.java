package com.example.marubatsudoroid;

public interface Player {

	/** ラベル(○や×)を示す１文字の文字列 */
	public abstract String getLabel();

	/** 自分のターンで選択するマス(0〜8)を返す */
	public abstract int playTurn(String[] board);
}
