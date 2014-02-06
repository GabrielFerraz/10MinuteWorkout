package com.example.sevenplus;

import com.example.utils.Utils;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class TimerActivity extends Activity {
	
	private CountDownTimer timer;
	private CountDownTimer timer2;
	public TextView tempo;
	public TextView exercicio;
	public final String[] exercicios = new String[12];
	public final String[] imagens = new String[12];
	public int numExercicio;
	ImageView imagem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		int tempoExercicio = Integer.parseInt(sharedPref.getString("exercicio", "28"));
		imagem = (ImageView) this.findViewById(R.id.imageView1);
		SQLiteDatabase db = Utils.getDB();
		Cursor c = db.query("exercicio", null, null, null, null, null, "exercicio_id");
		for(int i= 0;i<c.getCount();i++){
            c.moveToPosition(i);
                         
            exercicios[i] = c.getString(c.getColumnIndex("nome"));
            imagens[i] = c.getString(c.getColumnIndex("imagem"));
        }   
		tempo = (TextView) this.findViewById(R.id.TempoTimer);
		exercicio = (TextView) this.findViewById(R.id.nomeExercicioTimer);
		timer = new MyCountDownTimer(31000, 1000);
		timer2 = new MyCountDownTimer(6000, 1000);
		timer.start();
		numExercicio = 0;
		exercicio.setText(exercicios[0]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class MyCountDownTimer extends CountDownTimer {
		public long tempoInicial;
		public MyCountDownTimer(long startTime, long interval) {
			super(startTime, interval);
			tempoInicial = startTime;
		}

		@Override
		public void onFinish() {
			tempo.setText("0");
			if(numExercicio <= 12){
				if (tempoInicial == 31000){
					exercicio.setText("Descanso");
					timer2.start();
					numExercicio++;
				}else{
					exercicio.setText(exercicios[numExercicio]);
					int resourceId = getResources().getIdentifier(imagens[numExercicio], "drawable", "com.example.sevenplus");
					imagem.setImageResource(resourceId);
					timer.start();
				}
			}
		}

		@Override
		public void onTick(long millisUntilFinished) {
			tempo.setText("" + millisUntilFinished / 1000);
		}
	}
	

}
