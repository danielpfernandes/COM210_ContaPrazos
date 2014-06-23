package com.example.contaprazoscom210;

import com.example.contaprazoscom112.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Activity_Sobre extends Activity{
	public final Context ctx = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sobre);	

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
			default:
				return super.onOptionsItemSelected(item);
			}
		}

	}
