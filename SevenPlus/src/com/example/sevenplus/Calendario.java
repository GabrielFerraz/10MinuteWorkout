package com.example.sevenplus;

import java.util.Calendar;
import com.example.calendar.CalendarActivity;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Calendario extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		startActivityForResult(new Intent(Intent.ACTION_PICK).setDataAndType(null, CalendarActivity.MIME_TYPE), 100);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if(resultCode==RESULT_OK) {
	    	int year = data.getIntExtra("year", 0);   // get number of year
	        int month = data.getIntExtra("month", 0); // get number of month 0..11
	        int day = data.getIntExtra("day", 0);     // get number of day 0..31

	        // format date and display on screen
	        final Calendar dat = Calendar.getInstance();
	        dat.set(Calendar.YEAR, year);
	        dat.set(Calendar.MONTH, month);
	        dat.set(Calendar.DAY_OF_MONTH, day);
	        
	        // show result
	        Intent intent = new Intent(this.getBaseContext(), WorkoutActivity.class);
	        intent.putExtra("dataLongMiliseconds",dat.getTimeInMillis());
            startActivity(intent);
	        
	                
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar, menu);
		return true;
	}

}
