package com.example.marubatsudoroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements
		android.view.View.OnClickListener {
	public final String MARU = "o";
	public final String BATSU = "x";
	public int clickNumber = 0;
	public int playcount = 0;
	private TextView textResult;
	public String[] board = new String[9];
	public TextView[] textSquares;
	public boolean flgWin = false;
	ManualPlayer p1;
	// Level2Player p2;
	Level3Player p2;

	MarubatsuBoard mb = new MarubatsuBoard();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// TextView取得
		textResult = (TextView) findViewById(R.id.textViewResult);
		textSquares = new TextView[] {
				(TextView) findViewById(R.id.textViewSquares0),
				(TextView) findViewById(R.id.textViewSquares1),
				(TextView) findViewById(R.id.textViewSquares2),
				(TextView) findViewById(R.id.textViewSquares3),
				(TextView) findViewById(R.id.textViewSquares4),
				(TextView) findViewById(R.id.textViewSquares5),
				(TextView) findViewById(R.id.textViewSquares6),
				(TextView) findViewById(R.id.textViewSquares7),
				(TextView) findViewById(R.id.textViewSquares8) };

		// 各テキストにOnClickListenerをセット
		for (int i = 0; i < textSquares.length; i++) {
			textSquares[i].setOnClickListener(MainActivity.this);
		}
		// プレイヤーの設定
		p1 = new ManualPlayer(MARU);
		// p2 = new Level2Player(BATSU);
		p2 = new Level3Player(BATSU);
	}

	// クリック時に各升目に設定
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.textViewSquares0:
			clickNumber = 0;
			break;
		case R.id.textViewSquares1:
			clickNumber = 1;
			break;
		case R.id.textViewSquares2:
			clickNumber = 2;
			break;
		case R.id.textViewSquares3:
			clickNumber = 3;
			break;
		case R.id.textViewSquares4:
			clickNumber = 4;
			break;
		case R.id.textViewSquares5:
			clickNumber = 5;
			break;
		case R.id.textViewSquares6:
			clickNumber = 6;
			break;
		case R.id.textViewSquares7:
			clickNumber = 7;
			break;
		case R.id.textViewSquares8:
			clickNumber = 8;
			break;
		}

		// 操作者のラベル設定・勝敗確認
		select(clickNumber, p1);
		// 空き升がある、または勝敗がついていない場合
		if (playcount < 8 && flgWin == false) {
			// コンピュータの処理を実施
			select(p2.playTurn(getbord()), p2);
		}
	}

	// 指定升にラベル設定、および勝敗確認
	public void select(int n, Player p) {
		textSquares[n].setText(p.getLabel());
		textSquares[n].setClickable(false);

		// 勝敗確認
		if (mb.isWin(p, getbord())) {
			textResult.setText(p.getLabel() + " の勝ちです");
			flgWin = true;
			// 空き升の押下を不可設定
			for (int i = 0; i < textSquares.length; i++) {
				textSquares[i].setClickable(false);
			}
			return;
		}
		// 全ての升が埋まった場合は引き分け
		if (playcount == 8) {
			textResult.setText("引き分けです");
			return;
		}
		playcount++;
	}

	// 現在の設定状況を取得
	public String[] getbord() {
		for (int i = 0; i < textSquares.length; i++) {
			board[i] = textSquares[i].getText().toString();
		}
		return board;
	}

	// ボードの値をクリア（初期化）
	public void clearclick(View view) {
		flgWin = false;
		playcount = 0;
		for (int i = 0; i < textSquares.length; i++) {
			textSquares[i].setText("");
			textSquares[i].setClickable(true);
		}
		textResult.setText("");
	}
}
