package com.example.contaprazoscom112;


import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

public class Splash extends Activity implements Runnable {
	private final int DELAY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        File pasta = new File(Environment.getExternalStorageDirectory() + File.separator + "ContaPrazos");
		if (!pasta.exists()) {
			pasta.mkdir();
		}
        Handler handler = new Handler();
		handler.postDelayed(this, DELAY);
    }


    
    
    public void run() {
    	SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);
    	String cadastrado = sharedPreferences.getString("cadastrado", "");
		if (cadastrado.equals("true")) {
			Intent it = new Intent(this, Activity_Login.class);    	
			startActivity(it);		
		}else if(cadastrado.equals("logado")){
			Intent it = new Intent(this, Activity_ListaProcessos.class);    	
			startActivity(it);
			finish();
		} 
    	else {
			Intent it = new Intent(this, Activity_CadUsuario.class);    	
			startActivity(it);		
		}

		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);		
		finish();   	

	}
    
}
