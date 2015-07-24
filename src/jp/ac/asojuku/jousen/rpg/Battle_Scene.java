package jp.ac.asojuku.jousen.rpg;

import java.util.Random;

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
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Battle_Scene extends Activity {

    private AlertDialog.Builder alertDialog;
    private ProgressBar progressBar;
	private SQLiteDatabase sqlDB;
	DBManager dbm;
	private ImageView img;
	private TextView hp_e;
	private TextView hp_p;
	private int player_hp;
	private int enemy_hp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle_scene);

		dbm = new DBManager(this);
		sqlDB = dbm.getWritableDatabase();

		SQLiteCursor cursor_hp_e = null;
		SQLiteCursor cursor_hp_p = null;

		cursor_hp_p = dbm.selectHp(sqlDB);
		cursor_hp_p.moveToFirst();
		cursor_hp_e = dbm.selectEnemyHp(sqlDB);
		cursor_hp_e.moveToFirst();

		String player = cursor_hp_p.getString(cursor_hp_p.getColumnIndex("hp"));
		String enemy = cursor_hp_e.getString(cursor_hp_e.getColumnIndex("hp"));

		player_hp = Integer.parseInt(player);
		enemy_hp = Integer.parseInt(enemy);

        progressBar = (ProgressBar) findViewById(R.id.progressBar_hp);
        progressBar.setMax(enemy_hp);
        progressBar.setProgress(enemy_hp);
        progressBar.setSecondaryProgress(enemy_hp);

        hp_e = (TextView)findViewById(R.id.textView_hp);
        hp_p = (TextView)findViewById(R.id.textView2);


	}

	@Override
	protected void onResume() {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�
		super.onResume();
		dbm = new DBManager(this);
		sqlDB = dbm.getWritableDatabase();

		SQLiteCursor cursor_hp_e = null;
		SQLiteCursor cursor_hp_p = null;

		cursor_hp_p = dbm.selectHp(sqlDB);
		cursor_hp_p.moveToFirst();
		cursor_hp_e = dbm.selectEnemyHp(sqlDB);
		cursor_hp_e.moveToFirst();

		String player = cursor_hp_p.getString(cursor_hp_p.getColumnIndex("hp"));
		String enemy = cursor_hp_e.getString(cursor_hp_e.getColumnIndex("hp"));

		player_hp = Integer.parseInt(player);
		enemy_hp = Integer.parseInt(enemy);

        progressBar = (ProgressBar) findViewById(R.id.progressBar_hp);
        progressBar.setMax(enemy_hp);
        progressBar.setProgress(enemy_hp);
        progressBar.setSecondaryProgress(enemy_hp);

        hp_e = (TextView)findViewById(R.id.textView_hp);
        hp_p = (TextView)findViewById(R.id.textView2);

		img = (ImageView) findViewById(R.id.imageView1);
		Resources res = getResources();
		Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.mon_022);

		img.setImageBitmap(bmp);


		Button battle = (Button)findViewById(R.id.battle);
		battle.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ
				Random rnd = new Random();
				int ran = rnd.nextInt(4);

				//AlphaAnimation(float fromAlpha, float toAlpha)
				AlphaAnimation alpha = new AlphaAnimation(1, 0);
				//1000ms邵ｺ�ｽｮ鬮｢阮吶��
				alpha.setDuration(1000);
				//3陜玲ｨ抵ｽｹ�ｽｰ郢ｧ鬘假ｽｿ譁絶�
				alpha.setInterpolator(new CycleInterpolator(3));
				img.startAnimation(alpha);

				RotateAnimation rotate = new RotateAnimation(0, 360, 50, 50);
				// img邵ｺ�ｽｮ闕ｳ�ｽｭ陟｢繝ｻ�ｽ帝怕�ｽｸ邵ｺ�ｽｫ邵ｲ繝ｻ陟趣ｽｦ邵ｺ荵晢ｽ�360陟趣ｽｦ邵ｺ�ｽｫ邵ｺ荵晢ｿ�邵ｺ�ｽｦ陜玲ｫ�ｽｻ�ｽ｢
				rotate.setDuration(500); // 500ms邵ｺ荵晢ｿ�邵ｺ�ｽｦ郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ邵ｺ蜷ｶ�ｽ�

				ScaleAnimation scale = new ScaleAnimation(1, 0.0f, 1, 0.0f); // img郢ｧ繝ｻ陋滄亂ﾂｰ郢ｧ繝ｻ.0陋滄亂竊馴し�ｽｮ陝�繝ｻ
				scale.setDuration(500); // 500ms邵ｺ荵晢ｿ�邵ｺ�ｽｦ郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ邵ｺ蜷ｶ�ｽ�

				TranslateAnimation translate = new TranslateAnimation(0, 400, 0, 0); // (0,0)邵ｺ荵晢ｽ�(-500,0)邵ｺ�ｽｫ驕假ｽｻ陷阪�ｻ
				translate.setDuration(500); // 500ms邵ｺ荵晢ｿ�邵ｺ�ｽｦ郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ邵ｺ蜷ｶ�ｽ�

/*
				switch (ran){
				case 0:
					//郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ郢ｧ�ｽｹ郢ｧ�ｽｿ郢晢ｽｼ郢昴�ｻ
					img.startAnimation(alpha);
					break;

				case 1:

					img.startAnimation(rotate); // 郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ鬩包ｽｩ騾包ｽｨ
					break;

				case 2:

					img.startAnimation(scale); // 郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ鬩包ｽｩ騾包ｽｨ
					break;

				case 3:

					img.startAnimation(translate); // 郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ鬩包ｽｩ騾包ｽｨ
					break;

				default:
					img.startAnimation(alpha); // 郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ鬩包ｽｩ騾包ｽｨ
					break;

				}
*/
				//郢晁�後�ｻ邵ｺ�ｽｮ隴崢�陞滂ｽｧ陋滂ｽ､郢ｧ雋槫徐陟輔�ｻ
				int max = progressBar.getMax();

				//郢晁�後�ｻ邵ｺ�ｽｮ陋滂ｽ､郢ｧ雋槫徐陟輔�ｻ
				int prog = progressBar.getProgress();
				progressBar.setProgress(prog - 10);
				int prog2 = progressBar.getProgress();

				//郢晁�後�ｻ邵ｺ�ｽｮ郢ｧ�ｽｻ郢ｧ�ｽｫ郢晢ｽｳ郢敖�郢晢ｽｪ陋滂ｽ､郢ｧ雋槫徐陟輔�ｻ
				int seco = progressBar.getSecondaryProgress();
				progressBar.setSecondaryProgress(seco - 10);

				hp_e.setText(prog2 + "/" + max);

/*				sleep(1000);
*/

				onPause();

				player_hp -= 10;
				hp_p.setText("HP " + player_hp);

			}
		});

/*		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
*/


		Button magic = (Button)findViewById(R.id.magic);
		magic.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ
				Random rnd = new Random();
				int ran = rnd.nextInt(4);

				AnimationSet set = new AnimationSet(true);

				RotateAnimation rotate = new RotateAnimation(0, 360, 70, 70); // img邵ｺ�ｽｮ闕ｳ�ｽｭ陟｢繝ｻ�ｽ帝怕�ｽｸ邵ｺ�ｽｫ邵ｲ繝ｻ陟趣ｽｦ邵ｺ荵晢ｽ�360陟趣ｽｦ邵ｺ�ｽｫ邵ｺ荵晢ｿ�邵ｺ�ｽｦ陜玲ｫ�ｽｻ�ｽ｢
				set.addAnimation(rotate);

				ScaleAnimation scale = new ScaleAnimation(1, 0.0f, 1, 0.0f); // img郢ｧ繝ｻ陋滄亂ﾂｰ郢ｧ繝ｻ.5陋滄亂竊馴し�ｽｮ陝�繝ｻ
				set.addAnimation(scale);

				set.setDuration(1000); // 3000ms邵ｺ荵晢ｿ�邵ｺ�ｽｦ郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ邵ｺ蜷ｶ�ｽ�
				img.startAnimation(set); // 郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ鬩包ｽｩ騾包ｽｨ


				switch (ran){
				case 0:
					//郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ郢ｧ�ｽｹ郢ｧ�ｽｿ郢晢ｽｼ郢昴�ｻ
					img.startAnimation(set);
					break;

				case 1:

					img.startAnimation(rotate); // 郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ鬩包ｽｩ騾包ｽｨ
					break;

				case 2:

					img.startAnimation(scale); // 郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ鬩包ｽｩ騾包ｽｨ
					break;

				case 3:

					img.startAnimation(set); // 郢ｧ�ｽ｢郢昜ｹ斟鍋ｹ晢ｽｼ郢ｧ�ｽｷ郢晢ｽｧ郢晢ｽｳ鬩包ｽｩ騾包ｽｨ
					break;
				}
			}
		});

		alertDialog = new AlertDialog.Builder(this);
		Button escape = (Button)findViewById(R.id.escape);
		escape.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
			    alertDialog.setTitle("リタイア");
			    alertDialog.setMessage("リタイアしますか？");
			    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int whichButton) {
			            // 郢晄㈱縺｡郢晢ｽｳ隰夲ｽｼ闕ｳ蛹ｺ蜃ｾ邵ｺ�ｽｮ陷�ｽｦ騾�繝ｻ
			        	Intent intent = new Intent(Battle_Scene.this, Behavior_Select.class);
			        	startActivity(intent);
			        }
			    });
			    alertDialog.setNegativeButton("Cansel", new OnClickListener() {
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

	}

	@Override
	protected void onPause() {
		// TODO 自動生成されたメソッド・スタブ
		super.onPause();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 髢ｾ�ｽｪ陷肴�募�ｽ隰瑚�鯉ｼ�郢ｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽｽ郢昴�ｻ繝ｩ郢晢ｽｻ郢ｧ�ｽｹ郢ｧ�ｽｿ郢昴�ｻ
		alertDialog = new AlertDialog.Builder(this);
	    alertDialog.setTitle("リタイア");
	    alertDialog.setMessage("リタイアしますか？");
	    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int whichButton) {
	            // 郢晄㈱縺｡郢晢ｽｳ隰夲ｽｼ闕ｳ蛹ｺ蜃ｾ邵ｺ�ｽｮ陷�ｽｦ騾�繝ｻ
	        	Intent intent = new Intent(Battle_Scene.this, Behavior_Select.class);
	        	startActivity(intent);
	        }
	    });
	    alertDialog.setNegativeButton("Cansel", new OnClickListener() {
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
		return super.onKeyDown(keyCode, event);
	}

	public synchronized void sleep(long msec){
    	try{
    		wait(msec);
    	}catch(InterruptedException e){

    	}
	}
}
