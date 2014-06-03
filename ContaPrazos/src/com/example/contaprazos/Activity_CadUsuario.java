package com.example.contaprazos;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
			

			
			
			
			//Componentes
			
			Button btnSalvar = (Button) findViewById(R.id.buttonSalvar);
			
			
			
			btnSalvar.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View arg0) {

					salvarnobd();
					Toast.makeText(ctx, "SALVOU NO BANCO", 1).show();


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
	
			LinearLayout Dt = (LinearLayout) findViewById(R.id.layoutdata);
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
			Toast.makeText(ctx, usuario.toString(), 1).show();
			usuario._id = repositorio.salvarUsuario(usuario);
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
