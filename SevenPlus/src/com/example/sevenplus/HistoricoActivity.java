package com.example.sevenplus;


import com.example.utils.Utils;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;

public class HistoricoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historico);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		
		 final CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView1);
		 
	        // quando selecionado alguma data diferente da padrão
	        calendarView.setOnDateChangeListener(new OnDateChangeListener() {
	 
	            @Override
	            public void onSelectedDayChange(CalendarView view, int year,
	                    int month, int dayOfMonth) {
	            	Intent intent = new Intent(view.getContext(), WorkoutActivity.class);
	                //intent.putExtra("dia", dayOfMonth);
	                //intent.putExtra("mes", month);
	                //intent.putExtra("ano", year);
	            	intent.putExtra("dataLongMiliseconds",view.getDate());
	            	
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
	
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId() != R.id.historico){		
        startActivity(Utils.opcao(item, this.getApplicationContext()));
        return true;
		}
        return false;
    }

}
