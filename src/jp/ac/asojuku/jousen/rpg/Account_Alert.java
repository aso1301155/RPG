package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Account_Alert extends Activity {

	private SQLiteDatabase sqlDB;
	DBManager dbm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_alert);
	}

	@Override
	protected void onResume() {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
		super.onResume();
		dbm = new DBManager(this);
		sqlDB = dbm.getWritableDatabase();

		SQLiteCursor cursor_p = null;
		SQLiteCursor cursor_j = null;

		cursor_p = dbm.selectPlayer(sqlDB);
		cursor_p.moveToFirst();
		cursor_j = dbm.selectJob(sqlDB);
		cursor_j.moveToFirst();

		String name = cursor_p.getString(cursor_p.getColumnIndex("name"));
		String job = cursor_j.getString(cursor_j.getColumnIndex("name"));

		TextView text_n = (TextView)findViewById(R.id.account_name);
		text_n.setText(name);

		ImageView img = (ImageView)findViewById(R.id.acccount_job);
		if(job.equals("謌ｦ螢ｫ")){
			Resources res = getResources();
			Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.sensi);

			img.setImageBitmap(bmp);
		}else if(job.equals("鬲泌ｰ主｣ｫ")){
			Resources res = getResources();
			Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.majo);

			img.setImageBitmap(bmp);
		}

		Button OK = (Button)findViewById(R.id.OK);
		OK.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				Intent ok = new Intent(Account_Alert.this,Behavior_Select.class	);
				startActivity(ok);
			}

		});

		Button Cancel = (Button)findViewById(R.id.Cancel);
		Cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				Intent back = new Intent(Account_Alert.this, New_Account.class);
				startActivity(back);
			}
		});

	}
}
