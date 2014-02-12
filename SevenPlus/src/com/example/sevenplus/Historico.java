package com.example.sevenplus;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.example.utils.Utils;
import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class Historico extends Activity {
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.historico);
		
		final SQLiteDatabase db;
		db = Utils.getDB();
		
		Calendar nextYear = Calendar.getInstance();
		nextYear.add(Calendar.YEAR, 1);
		
		Calendar lastYear = Calendar.getInstance();
		    lastYear.add(Calendar.YEAR, -1);

		final CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
		calendar.init(lastYear.getTime(), nextYear.getTime()) //
        .inMode(SelectionMode.SINGLE) //
        .withSelectedDate(new Date());
		
		Button visualizar = (Button) findViewById( R.id.visualizar );
		visualizar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date data = new Date();
				Cursor c = db.query("historico", null, "data=?", new String[] {dateFormat.format(calendar.getSelectedDate())}, null, null, "historico_id");
				if(c.getCount() != 0){
					c.moveToPosition(0);
					Intent intent = new Intent(getBaseContext(), WorkoutActivity.class);
	            	intent.putExtra("treino_id",c.getInt(c.getColumnIndex("treino_id")));
	                startActivity(intent);
				}else{
					Toast.makeText(getApplicationContext(), "Nao houve treino nesse dia", Toast.LENGTH_SHORT).show();
				}
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
