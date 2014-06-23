package com.example.contaprazoscom210;

import com.example.contaprazoscom112.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Login extends Activity{

	@Override
	    protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_login);	
	        logar();    
	}
	
	
	
	public void logar(){
		Button btnLogar = (Button) findViewById(R.id.btnLogar);
        btnLogar.setOnClickListener(new Button.OnClickListener() {
    		public void onClick(View arg0) {
    	
    	        prosseguir();
    		}
    	});
        
		
	}
	public void prosseguir(){
		
		CheckBox checked =(CheckBox) findViewById(R.id.checkpermanecer);
		EditText editnome = (EditText) findViewById(R.id.editnomelogin);
		EditText editsenha = (EditText) findViewById(R.id.editsenhalogin);
		
		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", MODE_PRIVATE);
		String nome = sharedPreferences.getString("nome", "");
		String senha = sharedPreferences.getString("senha", "");
		
		if((editnome.getText().toString().equals(nome)) && editsenha.getText().toString().equals(senha)){

			if(checked.isChecked()) SavePreferences("cadastrado", "logado");
			
			Intent it = new Intent(this, Activity_ListaProcessos.class);    	
			startActivity(it);
			finish();
			
		}else{
			Toast.makeText(this,"senha ou login incorreto", 1).show();
			
			
		}
	}
	private void SavePreferences(String key, String value) {
		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
		
		
	}

