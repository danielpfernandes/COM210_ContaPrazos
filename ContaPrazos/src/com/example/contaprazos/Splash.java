package com.example.contaprazos;


import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }
    
    public void run() {
		//SharedPreferences prefs = getSharedPreferences("Imaflora", Activity.MODE_PRIVATE);
		//String usuario = prefs.getString("id", "");
		//if (usuario.equals("")) {
		//	Intent it = new Intent(this, ActivityIdentificacao.class);    	
		//	startActivity(it);		
		//} else {
			Intent it = new Intent(this, Activity_CadUsuario.class);    	
			startActivity(it);		
		//}

		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);		
		finish();   	

	}
    
}
