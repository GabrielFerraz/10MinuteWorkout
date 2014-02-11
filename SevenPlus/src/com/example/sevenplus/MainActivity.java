package com.example.sevenplus;

import com.example.utils.Utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		Button iniciar = (Button) findViewById( R.id.iniciar ); 
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		SQLiteDatabase db;
		db = Utils.getDB();
		if(db == null){
			db = Utils.criaDB(getBaseContext());
		}

		iniciar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent telaTimer = new Intent(arg0.getContext(), TimerActivity.class);
				startActivity(telaTimer);
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId() != R.id.home){		
        startActivity(Utils.opcao(item, this.getApplicationContext()));
        return true;
		}
        return false;
    }
	
	
	
	  
}
