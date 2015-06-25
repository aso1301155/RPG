package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Job_Select extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.job_select);

		Intent intent = getIntent();
		String str = intent.getStringExtra("text");

		ImageButton hito = (ImageButton)findViewById(R.id.hito);
		hito.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent comit = new Intent(Job_Select.this,Account_Alert.class);
				comit.putExtra("cnt", "hito");
				startActivity(comit);
			}
		});

		ImageButton majo = (ImageButton)findViewById(R.id.majo);
		majo.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent comit = new Intent(Job_Select.this,Account_Alert.class);
				comit.putExtra("cnt", "majo");
				startActivity(comit);
			}
		});

		ImageButton sensi = (ImageButton)findViewById(R.id.sensi);
		sensi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent comit = new Intent(Job_Select.this,Account_Alert.class);
				comit.putExtra("cnt", "sensi");
				startActivity(comit);
			}
		});
	}
}
