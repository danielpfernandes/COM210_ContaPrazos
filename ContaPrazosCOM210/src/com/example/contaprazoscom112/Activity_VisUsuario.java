package com.example.contaprazoscom112;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Activity_VisUsuario extends Activity{
	public Activity activity = this;
	public static Repositorio repositorio;
	private Usuario usuario = new Usuario();
	public final Context ctx = this;
	@Override
	public void onCreate(Bundle iciBundle) {
		super.onCreate(iciBundle);  
		repositorio = new Repositorio(this);
		setContentView(R.layout.activity_visualizarusuario);
		LoadPreferences();
		EditarUsuario();
		logoff();

	}

	private void LoadPreferences() {

		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);

		((TextView) findViewById(R.id.textnome)).setText(((TextView) findViewById(R.id.textnome)).getText().toString()+": "+sharedPreferences.getString("nome", ""));
		((TextView) findViewById(R.id.textdata)).setText(((TextView) findViewById(R.id.textdata)).getText().toString()+": "+sharedPreferences.getString("datadenascimento", ""));
		((TextView) findViewById(R.id.textcpf)).setText(((TextView) findViewById(R.id.textcpf)).getText().toString()+": "+sharedPreferences.getString("cpf", ""));

		((TextView) findViewById(R.id.textendereco)).setText(((TextView) findViewById(R.id.textendereco)).getText().toString()+": "+sharedPreferences.getString("endereco", ""));

		((TextView) findViewById(R.id.textcelular)).setText(((TextView) findViewById(R.id.textcelular)).getText().toString()+": "+sharedPreferences.getString("celular", ""));

		((TextView) findViewById(R.id.textemail)).setText(((TextView) findViewById(R.id.textemail)).getText().toString()+": "+sharedPreferences.getString("email", ""));

		((TextView) findViewById(R.id.textnumoab)).setText(((TextView) findViewById(R.id.textnumoab)).getText().toString()+": "+sharedPreferences.getString("numeroOAB", ""));

		((TextView) findViewById(R.id.textapelido)).setText(((TextView) findViewById(R.id.textapelido)).getText().toString()+": "+sharedPreferences.getString("apelido", ""));

	}
	public void EditarUsuario(){

		Button btnlogoff = (Button) findViewById(R.id.btnEditar);



		btnlogoff.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {

				SavePreferences("EditarUsuario", "TRUE");
				Intent intent = new Intent(ctx,
						Activity_CadUsuario.class);

				startActivity(intent);
				finish();
			}});


	}

	private void SavePreferences(String key, String value) {
		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public void logoff(){


		Button btnlogoff = (Button) findViewById(R.id.btnLogoff);



		btnlogoff.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {

				//limpando o PREFS
				SharedPreferences settings = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);
				settings.edit().clear().commit();
				repositorio.apagarProcesso();
				repositorio.apagarUsuario();
				Intent intent = new Intent(ctx,
						Activity_CadUsuario.class);
				startActivity(intent);
				finish();
			}});


	}
	// -----------------------------------------------------------------------------//
	// FINALIZANDO //
	// -----------------------------------------------------------------------------//
	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		repositorio.fechar();
	}
}