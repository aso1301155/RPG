package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

	private String danjon_name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle_result);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();

		Intent intent = getIntent();
		danjon_name = intent.getStringExtra("danjon_name");

		TextView danjon = (TextView)findViewById(R.id.danjon_name_result);
		danjon.setText(danjon_name);

		Button result = (Button)findViewById(R.id.result_button);
		result.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(ResultActivity.this, Behavior_Select.class);
				startActivity(intent);
			}
		});
	}
}
