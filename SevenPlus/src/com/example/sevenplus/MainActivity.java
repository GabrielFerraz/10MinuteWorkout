package com.example.sevenplus;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
//		ImageButton teste = (ImageButton) findViewById( R.id.imageButton1 ); 

//		teste.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Intent teste = new Intent(arg0.getContext(), this);
//				startActivity(teste);
//			}
//
//		});

		ImageButton teste2 = (ImageButton) findViewById( R.id.imageButton2 ); 

		teste2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent teste2 = new Intent(arg0.getContext(), HistoricoActivity.class);
				startActivity(teste2);
			}

		});

		ImageButton teste3 = (ImageButton) findViewById( R.id.imageButton3 ); 

		teste3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent teste3 = new Intent(arg0.getContext(), Instrucoes.class);
				startActivity(teste3);
			}

		});

		ImageButton teste4 = (ImageButton) findViewById( R.id.imageButton4 ); 

		teste4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent teste4 = new Intent(arg0.getContext(), Config.class);
				startActivity(teste4);
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	  
	  
}
