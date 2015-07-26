package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Danjon_Select extends Activity {

	private Button danjon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
		super.onCreate(savedInstanceState);
		setContentView(R.layout.danjon_select);
	}

	@Override
	protected void onResume() {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
		super.onResume();

		danjon = (Button)findViewById(R.id.what_legend);


		Button btn_m = (Button)findViewById(R.id.button_main);
		btn_m.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				Intent intent = new Intent(Danjon_Select.this, Behavior_Select.class);
				startActivity(intent);

			}
		});
		Button btn_d = (Button)findViewById(R.id.button_quest);
		btn_d.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				Intent intent = new Intent(Danjon_Select.this, Danjon_Select.class);
				startActivity(intent);
			}
		});
		Button btn_w = (Button)findViewById(R.id.button_soubi);
		Button btn_st = (Button)findViewById(R.id.button_status);
		Button btn_se = (Button)findViewById(R.id.button_setting);
		btn_se.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				Intent intent = new Intent(Danjon_Select.this, OptionActivity.class);
				startActivity(intent);
			}
		});


		Button what_legend = (Button)findViewById(R.id.what_legend);
		what_legend.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				Intent what_legend = new Intent(Danjon_Select.this,Battle_Scene.class);
				what_legend.putExtra("danjon_name", danjon.getText().toString());
				startActivity(what_legend);
			}
		});

	}
}
