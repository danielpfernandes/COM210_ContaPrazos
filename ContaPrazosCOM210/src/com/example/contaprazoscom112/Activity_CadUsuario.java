package com.example.contaprazoscom112;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Activity_CadUsuario extends Activity{
	public Activity activity = this;
	public static Repositorio repositorio;
	private Usuario usuario = new Usuario();
	public final Context ctx = this;
	//Data
	private int mYear, mMonth, mDay;
	static final int DATE_DIALOG_ID = 1;
	
	@Override
	    protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_cadusuario);	        
	        Data();
			repositorio = new Repositorio(this);
			Salvar();
			Editando();
	    }
	
	public void Editando(){

    	SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);

		if(sharedPreferences.getString("EditarUsuario", "").equals("TRUE")){
			
			((TextView) findViewById(R.id.textoEditouCad)).setText("       Alterar usuário    ");
			LoadPreferences();
		}
		
	}
	
	private void LoadPreferences() {
		
    	SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);

		 ((EditText) findViewById(R.id.editnome)).setText(sharedPreferences.getString("nome", ""));
		((TextView) findViewById(R.id.txtdata)).setText(sharedPreferences.getString("datadenascimento", ""));
		 ((EditText) findViewById(R.id.editcpf)).setText(sharedPreferences.getString("cpf", ""));
			
		((EditText) findViewById(R.id.editendereco)).setText(sharedPreferences.getString("endereco", ""));
			
	((EditText) findViewById(R.id.editcelular)).setText(sharedPreferences.getString("celular", ""));
			
		((EditText) findViewById(R.id.editemail)).setText(sharedPreferences.getString("email", ""));
		
		((EditText) findViewById(R.id.editnumoab)).setText(sharedPreferences.getString("numeroOAB", ""));
			
		((EditText) findViewById(R.id.editapelido)).setText(sharedPreferences.getString("apelido", ""));
			
		((EditText) findViewById(R.id.editsenha)).setText(sharedPreferences.getString("senha", ""));
			
	}
	
	public void Salvar(){
		ImageButton btnSalvar = (ImageButton) findViewById(R.id.imageSalvarUsuario);
		btnSalvar.setOnClickListener(new Button.OnClickListener() {
		public void onClick(View arg0) {
		salvarnobd();
		Intent intent = new Intent(ctx,
		Activity_ListaProcessos.class);
		startActivity(intent);
		finish();
		}
		});
		
		
	}
	// -----------------------------------------------------------------------------//
	// DISPLAY DE DATA //
	// -----------------------------------------------------------------------------//
		public void Data() {
	
			TextView mDateDisplay = (TextView) findViewById(R.id.txtdata);
	    	Button pickDate = (Button) findViewById(R.id.btndata);
	    	
			mDateDisplay.setText("");
			mDateDisplay.setTextColor(Color.BLACK);
			mDateDisplay.setTextSize(18);
			
			pickDate.setText("  Selecione  ");
			pickDate.setTextColor(Color.WHITE);
			pickDate.setTextSize(18);
			mDateDisplay.setPadding(30, 0, 10, 10);
			pickDate.setBackgroundResource(R.drawable.button_shape);
			pickDate.setOnClickListener(new View.OnClickListener() {
				@SuppressWarnings("deprecation")
				public void onClick(View v) {
					showDialog(DATE_DIALOG_ID);
				}
			});

			final Calendar c = Calendar.getInstance();
			mYear = c.get(Calendar.YEAR);
			mMonth = c.get(Calendar.MONTH);
			mDay = c.get(Calendar.DAY_OF_MONTH);
			updateDisplay();
		}
		
		@Override
		protected Dialog onCreateDialog(int id) {
			switch (id) {

			case DATE_DIALOG_ID:
				return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
						mDay);
			}
			return null;
		}

		protected void onPrepareDialog(int id, Dialog dialog) {
			switch (id) {

			case DATE_DIALOG_ID:
				((DatePickerDialog) dialog).updateDate(mYear, mMonth, mDay);
				break;
			}
		}

		private void updateDisplay() {
			String c = String.valueOf(mMonth + 1);
			if (c.length() == 1) {
				c = "0" + c;
			}
			TextView mDateDisplay = (TextView) findViewById(R.id.txtdata);
			mDateDisplay.setText(new StringBuilder()
					// Month is 0 based so add 1
			.append(mDay).append("/").append(c).append("/").append(mYear)
					.append(" "));
		}

		private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				mYear = year;
				mMonth = monthOfYear;
				mDay = dayOfMonth;
				updateDisplay();
			}
		};

		// -----------------------------------------------------------------------------//
		// SALVAR - BANCO DE DADOS //
		// -----------------------------------------------------------------------------//

		public void salvarnobd() {
			EditText nome = (EditText) findViewById(R.id.editnome);
			TextView data = (TextView) findViewById(R.id.txtdata);
			EditText cpf = (EditText) findViewById(R.id.editcpf);
			EditText endereco = (EditText) findViewById(R.id.editendereco);
			EditText celular = (EditText) findViewById(R.id.editcelular);
			EditText email = (EditText) findViewById(R.id.editemail);
			EditText numoab = (EditText) findViewById(R.id.editnumoab);
			EditText apelido = (EditText) findViewById(R.id.editapelido);
			EditText senha = (EditText) findViewById(R.id.editsenha);
			
			
			
			usuario.nomeusuario  = nome.getText().toString();
			usuario.datadenascimento = data.getText().toString();
			usuario.cpf = cpf.getText().toString();
			usuario.endereco = endereco.getText().toString();
			usuario.celular = celular.getText().toString();
			usuario.email = email.getText().toString();
			usuario.numeroOAB = numoab.getText().toString();
			usuario.apelido  = apelido.getText().toString();
			usuario.senha = senha.getText().toString();
			
			SavePreferences("cadastrado", "true");
			SavePreferences("nome", usuario.nomeusuario);
			SavePreferences("datadenascimento", usuario.datadenascimento);
			SavePreferences("cpf", usuario.cpf);
			
			SavePreferences("endereco", usuario.endereco);
			SavePreferences("celular", usuario.celular);
			SavePreferences("email", usuario.email);
			SavePreferences("numeroOAB", usuario.numeroOAB);
			SavePreferences("apelido", usuario.apelido);
			SavePreferences("senha", usuario.senha);
			

			usuario._id = repositorio.salvarUsuario(usuario);
			
				
			
		}
		private void SavePreferences(String key, String value) {
			SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", MODE_PRIVATE);
			SharedPreferences.Editor editor = sharedPreferences.edit();
			editor.putString(key, value);
			editor.commit();
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
