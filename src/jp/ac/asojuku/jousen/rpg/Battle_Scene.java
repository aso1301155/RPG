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

    private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle_scene);

        progressBar = (ProgressBar) findViewById(R.id.progressBar_hp);
        progressBar.setMax(100);
        progressBar.setProgress(100);
        progressBar.setSecondaryProgress(100);

        final TextView hp = (TextView)findViewById(R.id.textView_hp);

		Button battle = (Button)findViewById(R.id.battle);
		battle.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				ImageView img = (ImageView) findViewById(R.id.imageView1);
				Random rnd = new Random();
				int ran = rnd.nextInt(4);

				//AlphaAnimation(float fromAlpha, float toAlpha)
				AlphaAnimation alpha = new AlphaAnimation(1, 0);
				//1000ms縺ｮ髢薙〒
				alpha.setDuration(1000);
				//3蝗樒ｹｰ繧願ｿ斐☆
				alpha.setInterpolator(new CycleInterpolator(3));
				img.startAnimation(alpha);

				RotateAnimation rotate = new RotateAnimation(0, 360, 50, 50);
				// img縺ｮ荳ｭ蠢・ｒ霆ｸ縺ｫ縲・蠎ｦ縺九ｉ360蠎ｦ縺ｫ縺九￠縺ｦ蝗櫁ｻ｢
				rotate.setDuration(500); // 500ms縺九￠縺ｦ繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ縺吶ｋ

				ScaleAnimation scale = new ScaleAnimation(1, 0.0f, 1, 0.0f); // img繧・蛟阪°繧・.0蛟阪↓邵ｮ蟆・
				scale.setDuration(500); // 500ms縺九￠縺ｦ繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ縺吶ｋ

				TranslateAnimation translate = new TranslateAnimation(0, 400, 0, 0); // (0,0)縺九ｉ(-500,0)縺ｫ遘ｻ蜍・
				translate.setDuration(500); // 500ms縺九￠縺ｦ繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ縺吶ｋ

/*
				switch (ran){
				case 0:
					//繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ繧ｹ繧ｿ繝ｼ繝・
					img.startAnimation(alpha);
					break;

				case 1:

					img.startAnimation(rotate); // 繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ驕ｩ逕ｨ
					break;

				case 2:

					img.startAnimation(scale); // 繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ驕ｩ逕ｨ
					break;

				case 3:

					img.startAnimation(translate); // 繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ驕ｩ逕ｨ
					break;

				default:
					img.startAnimation(alpha); // 繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ驕ｩ逕ｨ
					break;

				}
*/
				//繝舌・縺ｮ譛螟ｧ蛟､繧貞叙蠕・
				int max = progressBar.getMax();

				//繝舌・縺ｮ蛟､繧貞叙蠕・
				int prog = progressBar.getProgress();
				progressBar.setProgress(prog - 10);
				int prog2 = progressBar.getProgress();

				//繝舌・縺ｮ繧ｻ繧ｫ繝ｳ繝繝ｪ蛟､繧貞叙蠕・
				int seco = progressBar.getSecondaryProgress();
				progressBar.setSecondaryProgress(seco - 10);

				hp.setText(prog2 + "/" + max);


			}
		});

		Button magic = (Button)findViewById(R.id.magic);
		magic.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
				ImageView img = (ImageView) findViewById(R.id.imageView1);
				Random rnd = new Random();
				int ran = rnd.nextInt(4);

				AnimationSet set = new AnimationSet(true);

				RotateAnimation rotate = new RotateAnimation(0, 360, 70, 70); // img縺ｮ荳ｭ蠢・ｒ霆ｸ縺ｫ縲・蠎ｦ縺九ｉ360蠎ｦ縺ｫ縺九￠縺ｦ蝗櫁ｻ｢
				set.addAnimation(rotate);

				ScaleAnimation scale = new ScaleAnimation(1, 0.0f, 1, 0.0f); // img繧・蛟阪°繧・.5蛟阪↓邵ｮ蟆・
				set.addAnimation(scale);

				set.setDuration(1000); // 3000ms縺九￠縺ｦ繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ縺吶ｋ
				img.startAnimation(set); // 繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ驕ｩ逕ｨ


				switch (ran){
				case 0:
					//繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ繧ｹ繧ｿ繝ｼ繝・
					img.startAnimation(set);
					break;

				case 1:

					img.startAnimation(rotate); // 繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ驕ｩ逕ｨ
					break;

				case 2:

					img.startAnimation(scale); // 繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ驕ｩ逕ｨ
					break;

				case 3:

					img.startAnimation(set); // 繧｢繝九Γ繝ｼ繧ｷ繝ｧ繝ｳ驕ｩ逕ｨ
					break;
				}
			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝・ラ繝ｻ繧ｹ繧ｿ繝・
	    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
	    alertDialog.setTitle("リタイア");
	    alertDialog.setMessage("リタイアしますか？");
	    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int whichButton) {
	            // 繝懊ち繝ｳ謚ｼ荳区凾縺ｮ蜃ｦ逅・
	        	Intent intent = new Intent(Battle_Scene.this, Behavior_Select.class);
	        	startActivity(intent);
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
