package jp.ac.asojuku.jousen.rpg;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class Battle_Scene extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle_scene);

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

				RotateAnimation rotate = new RotateAnimation(0, 360, img.getWidth()/2, img.getHeight()/2);
				// imgの中心を軸に、0度から360度にかけて回転
				rotate.setDuration(3000); // 3000msかけてアニメーションする

				ScaleAnimation scale = new ScaleAnimation(1, 0.5f, 1, 0.5f); // imgを1倍から0.5倍に縮小
				scale.setDuration(3000); // 3000msかけてアニメーションする

				TranslateAnimation translate = new TranslateAnimation(0, 100, 0, 100); // (0,0)から(100,100)に移動
				translate.setDuration(3000); // 3000msかけてアニメーションする


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

				RotateAnimation rotate = new RotateAnimation(0, 360, img.getWidth()/2, img.getHeight()/2); // imgの中心を軸に、0度から360度にかけて回転
				set.addAnimation(rotate);

				ScaleAnimation scale = new ScaleAnimation(1, 0.5f, 1, 0.5f); // imgを1倍から0.5倍に縮小
				set.addAnimation(scale);

				set.setDuration(3000); // 3000msかけてアニメーションする
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

					img.startAnimation(rotate); // アニメーション適用
					break;

				default:
					img.startAnimation(set); // アニメーション適用
					break;

				}
			}
		});


	}
}
