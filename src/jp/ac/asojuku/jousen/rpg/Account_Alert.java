package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Account_Alert extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_alert);

		String data = getIntent().getStringExtra("text");
		TextView name = (TextView)findViewById(R.id.account_name);
		name.setText(data);
		Button OK = (Button)findViewById(R.id.OK);
		OK.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent ok = new Intent(Account_Alert.this,Behavior_Select.class	);
				startActivity(ok);
			}

		});

		Button Cancel = (Button)findViewById(R.id.Cancel);
		Cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent back = new Intent(Account_Alert.this,Job_Select.class);
				startActivity(back);
		};
	});
}}
