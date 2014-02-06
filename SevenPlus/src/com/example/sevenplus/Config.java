package com.example.sevenplus;

import com.example.utils.Utils;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Config extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
//		getFragmentManager().beginTransaction()
//        .replace(android.R.id.content, new SettingsFragment())
//        .commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId() != R.id.configuracoes){		
        startActivity(Utils.opcao(item, this.getApplicationContext()));
        return true;
		}
        return false;
    }

}
