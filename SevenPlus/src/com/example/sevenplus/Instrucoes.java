package com.example.sevenplus;

import java.util.ArrayList;

import com.example.utils.Utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Instrucoes extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucoes);
        ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		SQLiteDatabase db = Utils.getDB();
		Cursor c = db.query("exercicio", null, null, null, null, null, "exercicio_id");
        final ListView listview = (ListView) findViewById(R.id.listViewExercicios);
        final String[] valores = new String[12];
        for(int i= 0;i<c.getCount();i++){
            c.moveToPosition(i);
                         
            valores[i] = c.getString(c.getColumnIndex("nome"));
        }
        final ArrayList<String> list = new ArrayList<String>();
        
        for (int i = 0; i < valores.length; i++){
        	list.add(valores[i]);
        }
        
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        
        listview.setAdapter(adapter);
        
        listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
			    Intent teste2 = new Intent(arg1.getContext(), Exercicio.class);
                teste2.putExtra("titulo",valores[arg2] );
                startActivity(teste2);

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
		
		if(item.getItemId() != R.id.instrucoes){		
        startActivity(Utils.opcao(item, this.getApplicationContext()));
        return true;
		}
        return false;
    }
}
