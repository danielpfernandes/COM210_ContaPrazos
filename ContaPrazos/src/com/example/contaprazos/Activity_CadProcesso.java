package com.example.contaprazos;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_CadProcesso extends Activity{
	
	public Activity activity = this;
	public static Repositorio repositorio;
	private Processo processo = new Processo();
	public final Context ctx = this;
	//Data
	private int mYear, mMonth, mDay;
	static final int DATE_DIALOG_ID = 1;
	
	@Override
	    protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_cadproceso);	        
	        Data();
			repositorio = new Repositorio(this);
			salvar();
	}
	
	
	//Interacoes

	//Componentes
	public void salvar(){
	ImageButton btnSalvar = (ImageButton) findViewById(R.id.imageButtonSalvar);
	
	
	
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
	// SALVAR - BANCO DE DADOS //
	// -----------------------------------------------------------------------------//
	
	public void salvarnobd() {
		EditText numprocesso  = (EditText) findViewById(R.id.editnumprocesso);
		EditText vara  = (EditText) findViewById(R.id.editvara);
		TextView datapublicacao  = (TextView) findViewById(R.id.txtdata);
		EditText jornal  = (EditText) findViewById(R.id.editjornal);
		EditText tribunal  = (EditText) findViewById(R.id.edittribunal);
		EditText cidade  = (EditText) findViewById(R.id.editcidade);
		EditText expediente  = (EditText) findViewById(R.id.editexpediente);
		EditText titulo  = (EditText) findViewById(R.id.edittitulo);
		EditText autor  = (EditText) findViewById(R.id.editautor);
		EditText reu   = (EditText) findViewById(R.id.editreu);
		EditText despacho   = (EditText) findViewById(R.id.editdespacho);
		EditText advogado  = (EditText) findViewById(R.id.editadvogado);
		
		processo.numprocesso = numprocesso.getText().toString(); 
		processo.vara = vara.getText().toString();  
		processo.datapublicacao = datapublicacao.getText().toString();  
		processo.jornal = jornal.getText().toString();  
		processo.tribunal = tribunal.getText().toString();  
		processo.cidade = cidade.getText().toString();  
		processo.expediente = expediente.getText().toString();  
		processo.titulo = titulo.getText().toString();  
		processo.autor = autor.getText().toString();  
		processo.reu = reu.getText().toString();  
		processo.despacho = despacho.getText().toString();  
		processo.advogado = advogado.getText().toString();
		
		
		processo._id = repositorio.salvarProcesso(processo);
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
