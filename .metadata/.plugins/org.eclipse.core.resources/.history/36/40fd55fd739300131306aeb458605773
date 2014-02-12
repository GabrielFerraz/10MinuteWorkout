package com.example.sevenplus;



import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Exercicio extends Activity {
	
	public String exercicio;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercicio);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		TextView tv = (TextView) findViewById(R.id.nome_exercicio);
		exercicio = (String) getIntent().getSerializableExtra("titulo");
		tv.setText(exercicio);
//		setContentView(tv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
