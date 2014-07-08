package com.example.contaprazoscom112;


import com.example.contaprazoscom112.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Activity_Configuracoes extends Activity{
	public final Context ctx = this;
	private final String[] listadias = { "1 dia", "2 dias",
			"3 dias", "4 dias", "5 dias", "6 dias", "7 dias"};	

	private final String[] listaCores = { "Vermelho", "Azul",
	"Amarelo"};	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracao);	
		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);
		String strcor = sharedPreferences.getString("COR", "");
		if(strcor.equals("") || strcor == null) strcor = "Azul";
		Spinner cor = (Spinner) findViewById(R.id.spinnerCor);
		ArrayAdapter<String> corarray = new ArrayAdapter<String>(this,
				R.layout.spinner_custom, listaCores);
		corarray.setDropDownViewResource(R.layout.spinner_list_custom);
		cor.setAdapter(corarray);
		int spinnerPositionCor = corarray.getPosition(strcor);
		cor.setSelection(spinnerPositionCor);

		String strprazomin = sharedPreferences.getString("NOTIFPRAZO", "");
		if(strprazomin.equals("") || strprazomin == null) strcor = "2 dias";

		Spinner tempo = (Spinner) findViewById(R.id.spinnertempominimo);
		ArrayAdapter<String> tempoarray = new ArrayAdapter<String>(this,
				R.layout.spinner_custom, listadias);
		tempoarray.setDropDownViewResource(R.layout.spinner_list_custom);
		tempo.setAdapter(tempoarray);
		int spinnerPositionTempo = tempoarray.getPosition(strprazomin);
		tempo.setSelection(spinnerPositionTempo);

		SalvarConfiguracoes();
	}
	public void SalvarConfiguracoes(){
		ImageButton btnSalvar = (ImageButton) findViewById(R.id.imageSalvarConfiguracoes);
		btnSalvar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				Integer icor = ((Spinner) findViewById(R.id.spinnerCor))
						.getSelectedItemPosition();
				SavePreferences("COR", listaCores[icor]);

				Integer iprazo = ((Spinner) findViewById(R.id.spinnertempominimo))
						.getSelectedItemPosition();

				SavePreferences("NOTIFPRAZO", listadias[iprazo]);

				Intent intent = new Intent(ctx,
						Activity_ListaProcessos.class);
				startActivity(intent);
				finish();
			}
		});


	}




	// -----------------------------------------------------------------------------//
	// MENU //
	// -----------------------------------------------------------------------------//
	private void SavePreferences(String key, String value) {
		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.layout.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {


		case R.id.menu_dest:
			SavePreferences("LISTARDESTAQUE", "TRUE");
			Intent intent = new Intent(ctx,
					Activity_ListaProcessos.class);

			startActivity(intent);
			finish();


			return true;

		case R.id.menu_proc:
			SavePreferences("LISTARDESTAQUE", "FALSE");
			intent = new Intent(ctx,
					Activity_ListaProcessos.class);

			startActivity(intent);
			finish();

			return true;

		case R.id.menu_sobre:
			intent = new Intent(ctx,
					Activity_Sobre.class);
			startActivity(intent);
			finish();
			return true;

		case R.id.menu_config:
			intent = new Intent(ctx,
					Activity_Configuracoes.class);

			startActivity(intent);
			finish();
			return true;

		case R.id.menu_rel:
			intent = new Intent(ctx,
					RelatorioCumpridoNaoCumprido.class);

			startActivity(intent);
			finish();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
