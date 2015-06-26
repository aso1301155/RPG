package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Danjon_Select extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.danjon_select);

		Button what_legend = (Button)findViewById(R.id.what_legend);
		what_legend.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent what_legend = new Intent(Danjon_Select.this,Battle_Scene.class);
				startActivity(what_legend);
			}
		});
	}
}
