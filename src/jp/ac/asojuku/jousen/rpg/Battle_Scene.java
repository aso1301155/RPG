package jp.ac.asojuku.jousen.rpg;

import java.util.Random;

import android.annotation.SuppressLint;
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
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Battle_Scene extends Activity {

    private AlertDialog.Builder alertDialog;
    private AlertDialog.Builder Dialog;
    private AlertDialog.Builder Portion;

    private ProgressBar progressBar;
    private Button item;
	private Button magic;

	private SQLiteDatabase sqlDB;
	DBManager dbm;

	private ImageView img;
	private TextView hp_e;
	private TextView hp_p;
	private TextView mp_p;

	private int player_hp;
	private int enemy_hp;
	private int player_mp;
	private int heal;
	private int heal_cnt;
	private int heal_max;

	private AlphaAnimation alpha;
	private String danjon_name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle_scene);
		}

	@SuppressLint("ShowToast")
	@Override
	protected void onResume() {
		super.onResume();
		dbm = new DBManager(this);
		sqlDB = dbm.getWritableDatabase();

		Intent intent = getIntent();
		danjon_name = intent.getStringExtra("danjon_name");

		SQLiteCursor cursor_hp_e = null;
		SQLiteCursor cursor_hp_p = null;
		SQLiteCursor cursor_m = null;

		cursor_hp_p = dbm.selectHp(sqlDB);
		cursor_hp_p.moveToFirst();
		cursor_hp_e = dbm.selectEnemyHp(sqlDB);
		cursor_hp_e.moveToFirst();
		cursor_m = dbm.selectMp(sqlDB);
		cursor_m.moveToFirst();

		String player = cursor_hp_p.getString(cursor_hp_p.getColumnIndex("hp"));
		String enemy = cursor_hp_e.getString(cursor_hp_e.getColumnIndex("hp"));
		String mp = cursor_m.getString(cursor_m.getColumnIndex("mag"));

		player_hp = Integer.parseInt(player);
		heal = (int) (player_hp * 0.5);
		heal_cnt = 3;
		heal_max = player_hp;
		enemy_hp = Integer.parseInt(enemy);
		player_mp = Integer.parseInt(mp);

        progressBar = (ProgressBar) findViewById(R.id.progressBar_hp);
        progressBar.setMax(enemy_hp);
        progressBar.setProgress(enemy_hp);
        progressBar.setSecondaryProgress(enemy_hp);

        hp_e = (TextView)findViewById(R.id.textView_hp);
        hp_p = (TextView)findViewById(R.id.battle_hp);
        mp_p = (TextView)findViewById(R.id.battle_mp);

        hp_e.setText(enemy_hp + "/" + enemy_hp);
        hp_p.setText("HP " + player_hp);
        mp_p.setText("MP " + player_mp);

		img = (ImageView) findViewById(R.id.imageView1);
		Resources res = getResources();
		Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.mon_022);

		img.setImageBitmap(bmp);


		Button battle = (Button)findViewById(R.id.battle);
		battle.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Random rnd = new Random();
				int ran = rnd.nextInt(5);

				alpha = new AlphaAnimation(1, 0);
				alpha.setDuration(1000);
				alpha.setInterpolator(new CycleInterpolator(3));
				img.startAnimation(alpha);

				int max = progressBar.getMax();

				int prog = progressBar.getProgress();
				progressBar.setProgress(prog - 10);
				int prog2 = progressBar.getProgress();

				int seco = progressBar.getSecondaryProgress();
				progressBar.setSecondaryProgress(seco - 10);

				hp_e.setText(prog2 + "/" + max);

				new Handler().postDelayed(delayFunc, 1000);

				if(progressBar.getProgress() == 0){
					Intent intent = new Intent(Battle_Scene.this, ResultActivity.class);
					intent.putExtra("danjon_name", danjon_name);
					startActivity(intent);
				}

			}
		});

		Dialog = new AlertDialog.Builder(this);
		magic = (Button)findViewById(R.id.magic);
		magic.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Random rnd = new Random();
				int ran = rnd.nextInt(4);

				AnimationSet set = new AnimationSet(true);

				alpha = new AlphaAnimation(1, 0);
				alpha.setDuration(1000);
				alpha.setInterpolator(new CycleInterpolator(3));

			    Dialog.setTitle("魔法");
			    Dialog.setMessage("魔法を選択してください");
			    Dialog.setPositiveButton("火炎", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int whichButton) {

			        	player_mp -= 5;
			        	mp_p.setText("MP " + player_mp);

						int max = progressBar.getMax();

						int prog = progressBar.getProgress();
						progressBar.setProgress(prog - 10);
						int prog2 = progressBar.getProgress();

						int seco = progressBar.getSecondaryProgress();
						progressBar.setSecondaryProgress(seco - 10);

						hp_e.setText(prog2 + "/" + max);

						img.startAnimation(alpha);
						new Handler().postDelayed(delayFunc, 1000);

						if(progressBar.getProgress() == 0){
							Intent intent = new Intent(Battle_Scene.this, ResultActivity.class);
							intent.putExtra("danjon_name", danjon_name);
							startActivity(intent);
						}

					    if(player_mp < 5){
					    	magic.setEnabled(false);
					    }

			        }
			    });

			    Dialog.setNeutralButton("氷結", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO 自動生成されたメソッド・スタブ

			        	player_mp -= 5;
			        	mp_p.setText("MP " + player_mp);

						int max = progressBar.getMax();

						int prog = progressBar.getProgress();
						progressBar.setProgress(prog - 10);
						int prog2 = progressBar.getProgress();

						int seco = progressBar.getSecondaryProgress();
						progressBar.setSecondaryProgress(seco - 10);

						hp_e.setText(prog2 + "/" + max);

						img.startAnimation(alpha);
						new Handler().postDelayed(delayFunc, 1000);

						if(progressBar.getProgress() == 0){
							Intent intent = new Intent(Battle_Scene.this, ResultActivity.class);
							intent.putExtra("danjon_name", danjon_name);
							startActivity(intent);
						}

					    if(player_mp < 5){
					    	magic.setEnabled(false);
					    }

					}
				});

			    Dialog.setNegativeButton("雷撃", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

			        	player_mp -= 5;
			        	mp_p.setText("MP " + player_mp);

						int max = progressBar.getMax();

						int prog = progressBar.getProgress();
						progressBar.setProgress(prog - 10);
						int prog2 = progressBar.getProgress();

						int seco = progressBar.getSecondaryProgress();
						progressBar.setSecondaryProgress(seco - 10);

						hp_e.setText(prog2 + "/" + max);

						img.startAnimation(alpha);
						new Handler().postDelayed(delayFunc, 1000);

						if(progressBar.getProgress() == 0){
							Intent intent = new Intent(Battle_Scene.this, ResultActivity.class);
							intent.putExtra("danjon_name", danjon_name);
							startActivity(intent);
						}

					    if(player_mp < 5){
					    	magic.setEnabled(false);
					    }

					}
				});
			    Dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
			        public void onCancel(DialogInterface dialog) {

			        }
			    });


			    Dialog.show();
			}
		});

		Portion = new AlertDialog.Builder(this);
		item = (Button)findViewById(R.id.item);
		item.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
			    Portion.setTitle("HP回復");
			    Portion.setMessage("回復しますか？　残り：" + heal_cnt);
			    Portion.setPositiveButton("はい", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int whichButton) {

		        		if(player_hp + heal > heal_max)
				        	 player_hp = heal_max;
		        		else
		        			player_hp += heal;

			        	 hp_p.setText("HP " + player_hp);
			        	 heal_cnt--;

			        	 if(heal_cnt == 0){
			        		 item.setEnabled(false);
			        	 }
			        }
			    });
			    Portion.setNegativeButton("いいえ", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
			    Portion.setOnCancelListener(new DialogInterface.OnCancelListener() {
			        public void onCancel(DialogInterface dialog) {

			        }
			    });
			    Portion.show();

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

			        	Intent intent = new Intent(Battle_Scene.this, Behavior_Select.class);
			        	startActivity(intent);
			        }
			    });
			    alertDialog.setNegativeButton("Cansel", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
			    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
			        public void onCancel(DialogInterface dialog) {

			        }
			    });
			    alertDialog.show();
			}
		});
	}

	private final Runnable delayFunc = new Runnable() {
		@Override
		public void run() {
			player_hp -= 10;
			hp_p.setText("HP " + player_hp);
		}
	};

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		alertDialog = new AlertDialog.Builder(this);
	    alertDialog.setTitle("リタイア");
	    alertDialog.setMessage("リタイアしますか？");
	    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int whichButton) {
	        	Intent intent = new Intent(Battle_Scene.this, Behavior_Select.class);
	        	startActivity(intent);
	        }
	    });
	    alertDialog.setNegativeButton("Cansel", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

			}
		});
	    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
	        public void onCancel(DialogInterface dialog) {

	        }
	    });
	    alertDialog.show();
		return super.onKeyDown(keyCode, event);
	}
}
