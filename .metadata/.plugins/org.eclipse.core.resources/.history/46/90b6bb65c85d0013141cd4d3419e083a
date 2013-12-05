package com.example.utils;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import com.example.sevenplus.Config;
import com.example.sevenplus.HistoricoActivity;
import com.example.sevenplus.Instrucoes;
import com.example.sevenplus.MainActivity;
import com.example.sevenplus.R;

public class Utils {	
	
	public static Intent opcao(MenuItem item, Context context){
		Intent intent;
		switch (item.getItemId()) {

        case R.id.home:
        	intent = new Intent(context, MainActivity.class);
            return intent;

        case R.id.historico:
        	intent = new Intent(context, HistoricoActivity.class);
            return intent;

        case R.id.instrucoes:
        	intent = new Intent(context, Instrucoes.class);
            return intent;
            
        case R.id.configuracoes:
        	intent = new Intent(context, Config.class);
            return intent;

        default:
            return null;
        }
	}

}
