package com.example.sevenplus;



import com.example.utils.Utils;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ImageView;
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
		ImageView imagem = (ImageView) findViewById(R.id.imagem_exercicio);
		exercicio = (String) getIntent().getSerializableExtra("titulo");
		SQLiteDatabase db = Utils.getDB();
		Cursor c = db.query("exercicio", null, "nome=?", new String[] {exercicio}, null, null, "exercicio_id");
		for(int i= 0;i<c.getCount();i++){
            c.moveToPosition(i);
                         
            tv.setText(c.getString(c.getColumnIndex("nome")));
            int resourceId = getResources().getIdentifier(c.getString(c.getColumnIndex("imagem")), "drawable", "com.example.sevenplus");
			imagem.setImageResource(resourceId);
        }
		
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
