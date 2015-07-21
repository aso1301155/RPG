package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class New_Account extends Activity {
	private SQLiteDatabase sqlDB;
	DBManager dbm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_account);

		dbm = new DBManager(this);
		sqlDB = dbm.getWritableDatabase();

		SQLiteCursor cursor_p = null;

		cursor_p = dbm.selectPlayer(sqlDB);

		cursor_p.moveToFirst();

		String name = cursor_p.getString(cursor_p.getColumnIndex("name"));

		if(name != null){
			Intent intent = new Intent(New_Account.this, Behavior_Select.class);
			startActivity(intent);
		}
	}

	@Override
	protected void onResume() {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
		super.onResume();

		Button comit = (Button)findViewById(R.id.commit);
		comit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				EditText editText1 = (EditText)findViewById(R.id.username);
				String text = editText1.getText().toString();
				if(text != null)dbm.updateName(sqlDB, text);

				Intent comit = new Intent(New_Account.this,Job_Select.class);
				startActivity(comit);
			}
		});

	}
}
