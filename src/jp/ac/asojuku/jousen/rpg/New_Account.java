package jp.ac.asojuku.jousen.rpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class New_Account extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_account);

		Button comit = (Button)findViewById(R.id.commit);
		comit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				EditText editText1 = (EditText)findViewById(R.id.username);
				String text = editText1.getText().toString();
				Intent intent= new Intent();
				intent.putExtra("text", text);
				Intent comit = new Intent(New_Account.this,Job_Select.class);
				startActivity(comit);
			}
		});
	}
}
