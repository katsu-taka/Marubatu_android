package com.example.marubatsudoroid;

public interface GamePlayable {
	/** ゲームを開始する */
	public void start();

	/** ゲームを開始していない状態にリセットする */
	public void reset();
}
