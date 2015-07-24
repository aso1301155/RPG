package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Job_Select extends Activity {

	private SQLiteDatabase sqlDB;
	DBManager dbm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�
		super.onCreate(savedInstanceState);
		setContentView(R.layout.job_select);

	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		dbm = new DBManager(this);
		sqlDB = dbm.getWritableDatabase();

		ImageButton hito = (ImageButton)findViewById(R.id.hito);
		hito.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�
				Intent comit = new Intent(Job_Select.this,Account_Alert.class);
				startActivity(comit);
			}
		});

		ImageButton majo = (ImageButton)findViewById(R.id.majo);
		majo.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�
				Intent comit = new Intent(Job_Select.this,Account_Alert.class);
				dbm.insertJobMag(sqlDB);
				startActivity(comit);
			}
		});

		ImageButton sensi = (ImageButton)findViewById(R.id.sensi);
		sensi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�
				Intent comit = new Intent(Job_Select.this,Account_Alert.class);
				dbm.insertJobAtk(sqlDB);
				startActivity(comit);
			}
		});

	}
}
