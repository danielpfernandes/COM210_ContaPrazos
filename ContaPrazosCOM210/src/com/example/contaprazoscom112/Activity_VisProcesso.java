package com.example.contaprazoscom112;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_VisProcesso extends Activity{
	public Activity activity = this;
	public static Repositorio repositorio;
	private Processo processo = new Processo();
	public final Context ctx = this;
	@Override
	public void onCreate(Bundle iciBundle) {
		super.onCreate(iciBundle);  
		repositorio = new Repositorio(this);
		setContentView(R.layout.activity_visualizarprocesso);
		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);


		String id = sharedPreferences.getString("idprocesso", "");
		processo = repositorio.buscarProcesso(Long.parseLong(id));

		LoadProcesso();
		Editar();
	}


	private void LoadProcesso() {
		((TextView) findViewById(R.id.textnumprocesso)).setText(((TextView) findViewById(R.id.textnumprocesso)).getText().toString()+": "+processo.numprocesso);
		((TextView) findViewById(R.id.textvara)).setText(((TextView) findViewById(R.id.textvara)).getText().toString()+": "+processo.vara);
		((TextView) findViewById(R.id.textdatapublicacao)).setText(((TextView) findViewById(R.id.textdatapublicacao)).getText().toString()+": "+processo.datapublicacao);
		((TextView) findViewById(R.id.textjornal)).setText(((TextView) findViewById(R.id.textjornal)).getText().toString()+": "+processo.jornal);
		((TextView) findViewById(R.id.texttribunal)).setText(((TextView) findViewById(R.id.texttribunal)).getText().toString()+": "+processo.tribunal);
		((TextView) findViewById(R.id.textcidade)).setText(((TextView) findViewById(R.id.textcidade)).getText().toString()+": "+processo.cidade);
		((TextView) findViewById(R.id.textexpediente)).setText(((TextView) findViewById(R.id.textexpediente)).getText().toString()+": "+processo.expediente);
		((TextView) findViewById(R.id.texttitulo)).setText(((TextView) findViewById(R.id.texttitulo)).getText().toString()+": "+processo.titulo);
		((TextView) findViewById(R.id.textautor)).setText(((TextView) findViewById(R.id.textautor)).getText().toString()+": "+processo.autor);
		((TextView) findViewById(R.id.textreu)).setText(((TextView) findViewById(R.id.textreu)).getText().toString()+": "+processo.reu);
		((TextView) findViewById(R.id.textdespacho)).setText(((TextView) findViewById(R.id.textdespacho)).getText().toString()+": "+processo.despacho);
		((TextView) findViewById(R.id.textprazo)).setText(((TextView) findViewById(R.id.textprazo)).getText().toString()+": "+processo.prazo);
		((TextView) findViewById(R.id.textadvogado)).setText(((TextView) findViewById(R.id.textadvogado)).getText().toString()+": "+processo.advogado);


	}


	public void Editar(){

		Button btneditarproc = (Button) findViewById(R.id.btneditarprocesso);



		btneditarproc.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {

				SavePreferences("EditarProcesso", "TRUE");
				Intent intent = new Intent(ctx,
						Activity_CadProcesso.class);

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
}
