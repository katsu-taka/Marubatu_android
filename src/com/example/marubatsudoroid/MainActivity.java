package com.example.marubatsudoroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements
		android.view.View.OnClickListener {
	public final int RESET_CODE = -9;
	public final String MARU = "o";
	public final String BATSU = "x";
	public int clickNumber = 0;
	public int playcount = 0;
	// private TextView textSquares0, textSquares1, textSquares2, textSquares3,
	// textSquares4, textSquares5, textSquares6, textSquares7,
	// textSquares8, textResult;
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
		// textSquares0 = (TextView) findViewById(R.id.textViewSquares0);
		// textSquares1 = (TextView) findViewById(R.id.textViewSquares1);
		// textSquares2 = (TextView) findViewById(R.id.textViewSquares2);
		// textSquares3 = (TextView) findViewById(R.id.textViewSquares3);
		// textSquares4 = (TextView) findViewById(R.id.textViewSquares4);
		// textSquares5 = (TextView) findViewById(R.id.textViewSquares5);
		// textSquares6 = (TextView) findViewById(R.id.textViewSquares6);
		// textSquares7 = (TextView) findViewById(R.id.textViewSquares7);
		// textSquares8 = (TextView) findViewById(R.id.textViewSquares8);
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

		select(clickNumber, p1);
		if (playcount < 8 && flgWin == false) {
			select(p2.playTurn(getbord()), p2);
		}
	}

	// public void setValue(View view) {
	// switch (view.getId()) {
	// case R.id.textViewSquares0:
	// clickNumber = 0;
	// break;
	// case R.id.textViewSquares1:
	// clickNumber = 1;
	// break;
	// case R.id.textViewSquares2:
	// clickNumber = 2;
	// break;
	// case R.id.textViewSquares3:
	// clickNumber = 3;
	// break;
	// case R.id.textViewSquares4:
	// clickNumber = 4;
	// break;
	// case R.id.textViewSquares5:
	// clickNumber = 5;
	// break;
	// case R.id.textViewSquares6:
	// clickNumber = 6;
	// break;
	// case R.id.textViewSquares7:
	// clickNumber = 7;
	// break;
	// case R.id.textViewSquares8:
	// clickNumber = 8;
	// break;
	// }
	//
	// select(clickNumber, p1);
	// if (playcount < 8) {
	// select(p2.playTurn(getbord()), p2);
	// }
	//
	// }

	public void select(int n, Player p) {
		textSquares[n].setText(p.getLabel());
		textSquares[n].setClickable(false);
		// switch (n) {
		// case 0:
		// textSquares0.setText(p.getLabel());
		// textSquares0.setClickable(false);
		// break;
		// case 1:
		// textSquares1.setText(p.getLabel());
		// textSquares1.setClickable(false);
		// break;
		// case 2:
		// textSquares2.setText(p.getLabel());
		// textSquares2.setClickable(false);
		// break;
		// case 3:
		// textSquares3.setText(p.getLabel());
		// textSquares3.setClickable(false);
		// break;
		// case 4:
		// textSquares4.setText(p.getLabel());
		// textSquares4.setClickable(false);
		// break;
		// case 5:
		// textSquares5.setText(p.getLabel());
		// textSquares5.setClickable(false);
		// break;
		// case 6:
		// textSquares6.setText(p.getLabel());
		// textSquares6.setClickable(false);
		// break;
		// case 7:
		// textSquares7.setText(p.getLabel());
		// textSquares7.setClickable(false);
		// break;
		// case 8:
		// textSquares8.setText(p.getLabel());
		// textSquares8.setClickable(false);
		// break;
		// }

		if (mb.isWin(p, getbord())) {
			textResult.setText(p.getLabel() + " の勝ちです");
			flgWin = true;
			return;
		}
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
		// board[0] = textSquares0.getText().toString();
		// board[1] = textSquares1.getText().toString();
		// board[2] = textSquares2.getText().toString();
		// board[3] = textSquares3.getText().toString();
		// board[4] = textSquares4.getText().toString();
		// board[5] = textSquares5.getText().toString();
		// board[6] = textSquares6.getText().toString();
		// board[7] = textSquares7.getText().toString();
		// board[8] = textSquares8.getText().toString();
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
		// textSquares0.setText("");
		// textSquares1.setText("");
		// textSquares2.setText("");
		// textSquares3.setText("");
		// textSquares4.setText("");
		// textSquares5.setText("");
		// textSquares6.setText("");
		// textSquares7.setText("");
		// textSquares8.setText("");
		// textSquares0.setClickable(true);
		// textSquares1.setClickable(true);
		// textSquares2.setClickable(true);
		// textSquares3.setClickable(true);
		// textSquares4.setClickable(true);
		// textSquares5.setClickable(true);
		// textSquares6.setClickable(true);
		// textSquares7.setClickable(true);
		// textSquares8.setClickable(true);
	}
}
