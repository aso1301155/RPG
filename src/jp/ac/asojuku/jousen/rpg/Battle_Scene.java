package jp.ac.asojuku.jousen.rpg;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle_scene);

        // 水平プログレスバーの最大値を設定します

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar_hp);
        progressBar.setMax(100);
        progressBar.setProgress(100);
        progressBar.setSecondaryProgress(100);

        final TextView hp = (TextView)findViewById(R.id.textView_hp);

		Button battle = (Button)findViewById(R.id.battle);
		battle.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				ImageView img = (ImageView) findViewById(R.id.imageView1);
				Random rnd = new Random();
				int ran = rnd.nextInt(4);

				//AlphaAnimation(float fromAlpha, float toAlpha)
				AlphaAnimation alpha = new AlphaAnimation(1, 0);
				//1000msの間で
				alpha.setDuration(1000);
				//3回繰り返す
				alpha.setInterpolator(new CycleInterpolator(3));
				img.startAnimation(alpha);

				RotateAnimation rotate = new RotateAnimation(0, 360, 50, 50);
				// imgの中心を軸に、0度から360度にかけて回転
				rotate.setDuration(500); // 500msかけてアニメーションする

				ScaleAnimation scale = new ScaleAnimation(1, 0.0f, 1, 0.0f); // imgを1倍から0.0倍に縮小
				scale.setDuration(500); // 500msかけてアニメーションする

				TranslateAnimation translate = new TranslateAnimation(0, 400, 0, 0); // (0,0)から(-500,0)に移動
				translate.setDuration(500); // 500msかけてアニメーションする

/*
				switch (ran){
				case 0:
					//アニメーションスタート
					img.startAnimation(alpha);
					break;

				case 1:

					img.startAnimation(rotate); // アニメーション適用
					break;

				case 2:

					img.startAnimation(scale); // アニメーション適用
					break;

				case 3:

					img.startAnimation(translate); // アニメーション適用
					break;

				default:
					img.startAnimation(alpha); // アニメーション適用
					break;

				}
*/
				//バーの最大値を取得
				int max = progressBar.getMax();

				//バーの値を取得
				int prog = progressBar.getProgress();
				progressBar.setProgress(prog - 10);
				int prog2 = progressBar.getProgress();

				//バーのセカンダリ値を取得
				int seco = progressBar.getSecondaryProgress();
				progressBar.setSecondaryProgress(seco - 10);

				hp.setText(prog2 + "/" + max);


			}
		});

		Button magic = (Button)findViewById(R.id.magic);
		magic.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				ImageView img = (ImageView) findViewById(R.id.imageView1);
				Random rnd = new Random();
				int ran = rnd.nextInt(4);

				AnimationSet set = new AnimationSet(true);

				RotateAnimation rotate = new RotateAnimation(0, 360, 70, 70); // imgの中心を軸に、0度から360度にかけて回転
				set.addAnimation(rotate);

				ScaleAnimation scale = new ScaleAnimation(1, 0.0f, 1, 0.0f); // imgを1倍から0.5倍に縮小
				set.addAnimation(scale);

				set.setDuration(1000); // 3000msかけてアニメーションする
				img.startAnimation(set); // アニメーション適用


				switch (ran){
				case 0:
					//アニメーションスタート
					img.startAnimation(set);
					break;

				case 1:

					img.startAnimation(rotate); // アニメーション適用
					break;

				case 2:

					img.startAnimation(scale); // アニメーション適用
					break;

				case 3:

					img.startAnimation(set); // アニメーション適用
					break;
				}
			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 自動生成されたメソッド・スタブ
	    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
	    alertDialog.setTitle("リタイア");
	    alertDialog.setMessage("リタイアしますか？");
	    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int whichButton) {
	            // ボタン押下時の処理
	        	Intent intent = new Intent(Battle_Scene.this, Behavior_Select.class);
	        	startActivity(intent);
	        }
	    });
	    alertDialog.setNegativeButton("Cansel", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO 自動生成されたメソッド・スタブ

			}
		});
	    // キャンセルイベント
	    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
	        public void onCancel(DialogInterface dialog) {
	            // キャンセルの処理
	        }
	    });
	    alertDialog.show();
		return super.onKeyDown(keyCode, event);
	}
}
