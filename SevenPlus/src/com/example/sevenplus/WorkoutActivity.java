package com.example.sevenplus;

import java.util.ArrayList;
import java.util.Date;

import com.example.utils.Utils;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class WorkoutActivity extends Activity {

	 private ListView mainListView ;  
	 private ArrayAdapter<String> listAdapter ;  
	    
	  /** Called when the activity is first created. */  
	  @Override  
	  public void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
	    setContentView(R.layout.activity_workout);  
	      
	    ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
	    // Find the ListView resource.   
	    mainListView = (ListView) findViewById( R.id.mainlistView );  
	  
	    // Create and populate a List of planet names.  
	    String[] planets = new String[] { "exercicio 1", "exercicio 2", "exercicio 3", "exercicio 4",  
	                                      "exercicio 5", "exercicio 6", "exercicio 7", "exercicio 8", 
	                                      "exercicio 9", "exercicio 10", "exercicio 11", "exercicio 12"};
	    
	    ArrayList<String> planetList = new ArrayList<String>();  
	    for (int i = 0; i < planets.length; i++){
	    	planetList.add(planets[i]);
        }
	      
	    // Create ArrayAdapter using the planet list.  
	    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);    
	      
	    // Set the ArrayAdapter as the ListView's adapter.  
	    mainListView.setAdapter( listAdapter );
	    
	    Intent intent= this.getIntent();
	    Bundle b = intent.getExtras();
	    if (b!=null){
	    	int x = b.getInt("dataLongMiliseconds");
	    	Date date = new Date(x);
	    	Toast.makeText(getApplicationContext(), "data "+date.toString(), Toast.LENGTH_SHORT).show();
	    	
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
