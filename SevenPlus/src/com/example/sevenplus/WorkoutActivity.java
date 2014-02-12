package com.example.sevenplus;

import java.util.ArrayList;
import java.util.Date;

import com.example.utils.Utils;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class WorkoutActivity extends Activity {

	 private ListView mainListView ; 
	 private TextView tempoExercicio;
	 private TextView tempoDescanso;
	 private TextView ciclos;
	 private ArrayAdapter<String> listAdapter ;  
	 String[] exercicios;
	    
	  /** Called when the activity is first created. */  
	  @Override  
	  public void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
	    setContentView(R.layout.activity_workout);  
	      
	    ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		
		SQLiteDatabase db;
		db = Utils.getDB();
	    // Find the ListView resource.   
	    mainListView = (ListView) findViewById( R.id.mainlistView );  
	    tempoExercicio = (TextView) findViewById(R.id.tvTempoExercicio);
	    tempoDescanso = (TextView) findViewById(R.id.tvTempoDescanso);
	    ciclos = (TextView) findViewById(R.id.qtdCiclos);
	    // Create and populate a List of planet names.  
	    exercicios = new String[12];
	    Cursor c = db.query("exercicio", null, null, null, null, null, "exercicio_id");
		for(int i= 0;i<c.getCount();i++){
            c.moveToPosition(i);
                         
            exercicios[i] = c.getString(c.getColumnIndex("nome"));
        } 
	    ArrayList<String> list = new ArrayList<String>();  
	    for (int i = 0; i < exercicios.length; i++){
	    	list.add(exercicios[i]);
        }
	      
	    // Create ArrayAdapter using the planet list.  
	    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, list);    
	      
	    // Set the ArrayAdapter as the ListView's adapter.  
	    mainListView.setAdapter( listAdapter );
	    
	    mainListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
			    Intent teste2 = new Intent(arg1.getContext(), Exercicio.class);
                teste2.putExtra("titulo",exercicios[arg2] );
                startActivity(teste2);

			}

 });
	    
	    Intent intent= this.getIntent();
	    Bundle b = intent.getExtras();
	    if (b!=null){
	    	c = db.query("treino", null, "treino_id=?", new String[] {Integer.toString(b.getInt("treino_id"))}, null, null, "treino_id");
	    	for(int i= 0;i<c.getCount();i++){
	    		
	    		c.moveToPosition(0);
	    		tempoDescanso.setText(c.getString(c.getColumnIndex("tempoDescanso")));
	    		tempoExercicio.setText(c.getString(c.getColumnIndex("tempoExercicio")));
	    		ciclos.setText(c.getString(c.getColumnIndex("ciclos")));
	    		
	    	}
	    	Date date = new Date(b.getLong("dataLongMiliseconds"));
	    	
	    	
	    }
	    
	    
	  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		
        startActivity(Utils.opcao(item, this.getApplicationContext()));
        return true;
    }

}
