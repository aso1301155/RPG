package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Behavior_Select extends Activity {

	private SQLiteDatabase sqlDB;
	DBManager dbm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
		super.onCreate(savedInstanceState);
		setContentView(R.layout.behavior_select);

		ImageView danjon = (ImageView)findViewById(R.id.button_danjon);
		danjon.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				Intent danjon_select = new Intent(Behavior_Select.this,Danjon_Select.class);
				startActivity(danjon_select);
			}
		});

		Button button_soubi = (Button)findViewById(R.id.button_soubi);
		button_soubi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				Intent button_soubi = new Intent(Behavior_Select.this,Weapon.class);
				startActivity(button_soubi);
			}
		});

		Button btn_m = (Button)findViewById(R.id.button_main);
		btn_m.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				Intent intent = new Intent(Behavior_Select.this, Behavior_Select.class);
				startActivity(intent);

			}
		});
		Button btn_d = (Button)findViewById(R.id.button_quest);
		btn_d.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				Intent danjon_select = new Intent(Behavior_Select.this,Danjon_Select.class);
				startActivity(danjon_select);
			}
		});
		Button btn_st = (Button)findViewById(R.id.button_status);
		Button btn_se = (Button)findViewById(R.id.button_setting);
		btn_se.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				Intent intent = new Intent(Behavior_Select.this, OptionActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onResume() {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
		super.onResume();
		dbm = new DBManager(this);
		sqlDB = dbm.getWritableDatabase();

		SQLiteCursor cursor_p = null;
		SQLiteCursor cursor_j = null;
		SQLiteCursor cursor_h = null;
		SQLiteCursor cursor_m = null;

		cursor_p = dbm.selectPlayer(sqlDB);
		cursor_p.moveToFirst();
		cursor_j = dbm.selectJob(sqlDB);
		cursor_j.moveToFirst();
		cursor_h = dbm.selectHp(sqlDB);
		cursor_h.moveToFirst();
		cursor_m = dbm.selectMp(sqlDB);
		cursor_m.moveToFirst();

		String name = cursor_p.getString(cursor_p.getColumnIndex("name"));
		String job = cursor_j.getString(cursor_j.getColumnIndex("name"));
		String hp = cursor_h.getString(cursor_h.getColumnIndex("hp"));
		String mp = cursor_m.getString(cursor_m.getColumnIndex("mag"));

		TextView text_n = (TextView)findViewById(R.id.title_name);
		text_n.setText(name);
		TextView text_j = (TextView)findViewById(R.id.title_job);
		text_j.setText(job);
		TextView text_h = (TextView)findViewById(R.id.title_hp);
		text_h.setText(hp);
		TextView text_m = (TextView)findViewById(R.id.title_mp);
		text_m.setText(mp);

		ImageView img = (ImageView)findViewById(R.id.imageView1);
		if(job.equals("戦士")){
			Resources res = getResources();
			Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.sensi);

			img.setImageBitmap(bmp);
		}else if(job.equals("魔道士")){
			Resources res = getResources();
			Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.majo);

			img.setImageBitmap(bmp);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
	    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
	    alertDialog.setTitle("アプリ終了");
	    alertDialog.setMessage("終了しますか？");
	    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int whichButton) {
	            // 繝懊ち繝ｳ謚ｼ荳区凾縺ｮ蜃ｦ逅・
	        	moveTaskToBack(true);
	        }
	    });
	    alertDialog.setNegativeButton("Cansel", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・

			}
		});
	    // 繧ｭ繝｣繝ｳ繧ｻ繝ｫ繧､繝吶Φ繝・
	    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
	        public void onCancel(DialogInterface dialog) {
	            // 繧ｭ繝｣繝ｳ繧ｻ繝ｫ縺ｮ蜃ｦ逅・
	        }
	    });
	    alertDialog.show();
		return super.onKeyDown(keyCode, event);
	}
}
