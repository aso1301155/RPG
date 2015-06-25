package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Behavior_Select extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.behavior_select);

		TextView danjon = (TextView)findViewById(R.id.danjon);
		danjon.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent danjon_select = new Intent(Behavior_Select.this,Danjon_Select.class);
				startActivity(danjon_select);
			}
		});
	}
}
