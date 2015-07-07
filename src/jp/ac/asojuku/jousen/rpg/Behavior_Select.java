package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Behavior_Select extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.behavior_select);

		ImageView danjon = (ImageView)findViewById(R.id.button_danjon);
		danjon.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent danjon_select = new Intent(Behavior_Select.this,Danjon_Select.class);
				startActivity(danjon_select);
			}
		});

		Button button_soubi = (Button)findViewById(R.id.button_soubi);
		button_soubi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent button_soubi = new Intent(Behavior_Select.this,Weapon.class);
				startActivity(button_soubi);
			}
		});
	}
}
