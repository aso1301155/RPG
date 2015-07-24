package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView start = (TextView)findViewById(R.id.START);
		start.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�
				Intent intent = new Intent(MainActivity.this,New_Account.class);
				startActivity(intent);
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�
	    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
	    alertDialog.setTitle("アプリ終了");
	    alertDialog.setMessage("終了しますか？");
	    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int whichButton) {
	            // 繝懊ち繝ｳ謚ｼ荳区凾縺ｮ蜃ｦ逅�
	        	moveTaskToBack(true);
	        }
	    });
	    alertDialog.setNegativeButton("Cansel", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�

			}
		});
	    // 繧ｭ繝｣繝ｳ繧ｻ繝ｫ繧､繝吶Φ繝�
	    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
	        public void onCancel(DialogInterface dialog) {
	            // 繧ｭ繝｣繝ｳ繧ｻ繝ｫ縺ｮ蜃ｦ逅�
	        }
	    });
	    alertDialog.show();
		return super.onKeyDown(keyCode, event);
	}
}
