package com.example.marubatsudoroid;

public class MarubatsuBoard {

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
}
