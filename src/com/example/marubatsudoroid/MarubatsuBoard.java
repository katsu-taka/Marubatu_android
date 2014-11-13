package com.example.marubatsudoroid;

public class MarubatsuBoard {
	// 012
	// 345
	// 678
	/** ゲーム盤の選択状況 */
	// public String[] board = { "", "", "", "", "", "", "", "", "" };
	/** 現在のターン数 */
	// public int turn = 0;

	/**
	 * ゲーム盤のnで指定された箇所が空欄であるか？
	 * 
	 * @param n
	 *            0～8までの数値
	 * @return 空欄の場合true, 誰かが選択済みの場合false
	 */
	public boolean isBlank(int n, String[] board) {
		// TODO フェーズ１で記述
		if (board[n].equals("")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ゲーム盤のnで指定された箇所を選択する
	 * 
	 * @param n
	 *            0～8までの数値
	 * @param player
	 *            nの箇所を選択するプレイヤー
	 */
	// public void select(int n, Player player) {
	// // TODO フェーズ１で記述
	// board[n] = player.getLabel();
	// }

	/**
	 * 指定プレイヤーが勝利しているか、ゲーム盤の状態を確認する
	 * 
	 * @param player
	 *            勝利を確認するプレイヤー
	 * @return 勝利している場合にtrue, それ以外はfalse
	 */
	public boolean isWin(Player player, String[] board) {
		// TODO フェーズ１で記述
		String plabel = player.getLabel();
		int[][] checkLines = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
				{ 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };
		for (int[] is : checkLines) {
			if (plabel.equals(board[is[0]]) && plabel.equals(board[is[1]])
					&& plabel.equals(board[is[2]])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * ゲーム版の状態を標準出力に表示します
	 */
	// public void printStatus() {
	// // TODO フェーズ１で記述
	// System.out.println("==========================================");
	// System.out.printf("%s%s%s\n", board[0], board[1], board[2]);
	// System.out.printf("%s%s%s\n", board[3], board[4], board[5]);
	// System.out.printf("%s%s%s\n", board[6], board[7], board[8]);
	// }
}
