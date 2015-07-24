package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OptionActivity extends Activity{

    private AlertDialog.Builder alertDialog;
    private AlertDialog.Builder Dialog;
	private EditText edit;
	private SQLiteDatabase sqlDB;
	DBManager dbm;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option);
	}

	@Override
	protected void onResume() {
		// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ
		super.onResume();
		dbm = new DBManager(this);
		sqlDB = dbm.getWritableDatabase();

		Button btn_m = (Button)findViewById(R.id.button_main);
		btn_m.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ
				Intent intent = new Intent(OptionActivity.this, Behavior_Select.class);
				startActivity(intent);

			}
		});
		Button btn_d = (Button)findViewById(R.id.button_quest);
		btn_d.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ
				Intent intent = new Intent(OptionActivity.this, Danjon_Select.class);
				startActivity(intent);
			}
		});
		Button btn_w = (Button)findViewById(R.id.button_soubi);
		Button btn_st = (Button)findViewById(R.id.button_status);
		Button btn_se = (Button)findViewById(R.id.button_setting);
		btn_se.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ
				Intent intent = new Intent(OptionActivity.this, OptionActivity.class);
				startActivity(intent);
			}
		});

		alertDialog = new AlertDialog.Builder(this);
		Dialog = new AlertDialog.Builder(this);
		Button btn_n = (Button)findViewById(R.id.button_name);
		btn_n.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ

				edit = new EditText(getApplicationContext());

			    alertDialog.setTitle("名前変更");
			    alertDialog.setView(edit);
			    alertDialog.setPositiveButton("変更", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int whichButton) {
			            // 郢晄㈱縺｡郢晢ｽｳ隰夲ｽｼ闕ｳ蛹ｺ蜃ｾ邵ｺ�ｽｮ陷�ｽｦ騾�繝ｻ
						String name = edit.getText().toString();
						if(edit != null)dbm.insertName(sqlDB, name);
						edit.setText("");
			        }
			    });
			    alertDialog.setNegativeButton("キャンセル", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ

					}
				});
			    // 郢ｧ�ｽｭ郢晢ｽ｣郢晢ｽｳ郢ｧ�ｽｻ郢晢ｽｫ郢ｧ�ｽ､郢晏生ﾎｦ郢昴�ｻ
			    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
			        public void onCancel(DialogInterface dialog) {
			            // 郢ｧ�ｽｭ郢晢ｽ｣郢晢ｽｳ郢ｧ�ｽｻ郢晢ｽｫ邵ｺ�ｽｮ陷�ｽｦ騾�繝ｻ
			        }
			    });
			    alertDialog.show();
			}
		});

		Button btn_f = (Button)findViewById(R.id.button_format);
		btn_f.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ
			    Dialog.setTitle("初期化");
			    Dialog.setMessage("データを初期化しますか");
			    Dialog.setPositiveButton("はい", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int whichButton) {
			            // 郢晄㈱縺｡郢晢ｽｳ隰夲ｽｼ闕ｳ蛹ｺ蜃ｾ邵ｺ�ｽｮ陷�ｽｦ騾�繝ｻ
						dbm.deletePlayer(sqlDB);
			        	moveTaskToBack(true);
			        }
			    });
			    Dialog.setNegativeButton("いいえ", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ

					}
				});
			    // 郢ｧ�ｽｭ郢晢ｽ｣郢晢ｽｳ郢ｧ�ｽｻ郢晢ｽｫ郢ｧ�ｽ､郢晏生ﾎｦ郢昴�ｻ
			    Dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
			        public void onCancel(DialogInterface dialog) {
			            // 郢ｧ�ｽｭ郢晢ｽ｣郢晢ｽｳ郢ｧ�ｽｻ郢晢ｽｫ邵ｺ�ｽｮ陷�ｽｦ騾�繝ｻ
			        }
			    });
			    Dialog.show();

			}
		});

	}
}
