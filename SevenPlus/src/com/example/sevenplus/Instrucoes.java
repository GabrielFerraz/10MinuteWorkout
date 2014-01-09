package com.example.sevenplus;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.utils.Utils;

public class Instrucoes extends ActionBarActivity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucoes);
        ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
        
        final ListView listview = (ListView) findViewById(R.id.listViewExercicios);
        final String[] valores = new String[] { "Jumping Jacks", "Wall Sit",
        		"Push Up", "Abdominal Crunch", "Step Up", "Squat","Triceps Dip",
        		"Plank","High Knees","Lunge","Push Ups and Rotation","Side Plank" };
        
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
