package com.example.contaprazoscom112;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_VisUsuario extends Activity{
	public Activity activity = this;
	public static Repositorio repositorio;
	private Usuario usuario = new Usuario();
	@Override
	public void onCreate(Bundle iciBundle) {
		super.onCreate(iciBundle);  
		repositorio = new Repositorio(this);
		setContentView(R.layout.activity_visualizarusuario);
		LoadPreferences();
	
	}
	
		private void LoadPreferences() {
		
	    	SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);

			 ((TextView) findViewById(R.id.textnome)).setText(((TextView) findViewById(R.id.textnome)).getText().toString()+": "+sharedPreferences.getString("nome", ""));
			 ((TextView) findViewById(R.id.textdata)).setText(sharedPreferences.getString("datadenascimento", ""));
				((TextView) findViewById(R.id.textcpf)).setText(sharedPreferences.getString("cpf", ""));
				
				((TextView) findViewById(R.id.textendereco)).setText(sharedPreferences.getString("endereco", ""));
				
				((TextView) findViewById(R.id.textcelular)).setText(sharedPreferences.getString("celular", ""));
				
				((TextView) findViewById(R.id.textemail)).setText(sharedPreferences.getString("email", ""));
			
				((TextView) findViewById(R.id.textnumoab)).setText(sharedPreferences.getString("numeroOAB", ""));
				
				((TextView) findViewById(R.id.textapelido)).setText(sharedPreferences.getString("apelido", ""));
				
	}
	
	
}