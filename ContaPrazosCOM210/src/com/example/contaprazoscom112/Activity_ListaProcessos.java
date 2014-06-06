package com.example.contaprazoscom112;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.Time;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_ListaProcessos extends Activity  {
	public static Repositorio repositorio;
	public final Context ctx = this;
	private int mYear, mMonth, mDay;


	List<Processo> listaproc = new ArrayList<Processo>();
	
	@Override
	public void onCreate(Bundle iciBundle) {
		super.onCreate(iciBundle);  
		Time today = new Time(Time.getCurrentTimezone());
		today.setToNow();

		mDay= today.monthDay; 
		mMonth = today.month;              
		mYear  = today.year; 
		
		repositorio = new Repositorio(this);
		setContentView(R.layout.activity_listarprocesso);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		CarregarTABELA();
		AdicionarProcesso();
		VisualizarUsuário();
	}
	
	public void CarregarProcessos(){
		List<Processo> ListaProcesso = repositorio.listarProcesso(String.valueOf(1));
			for(int i=0; i<ListaProcesso.size(); i++){	
				listaproc.add(ListaProcesso.get(i));
			}
	}

	public void CarregarTABELA() {
		TableLayout tabela = (TableLayout) findViewById(R.id.tabela_processo);
		tabela.removeAllViews();
		TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
		TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,Gravity.RIGHT | Gravity.CENTER_VERTICAL);
		tabela.setLayoutParams(tableParams);
		CarregarProcessos();
		
		for(int num=0; num<listaproc.size(); num++){	
			TableRow tableRow1 = new TableRow(getApplicationContext());
			tableRow1.setLayoutParams(tableParams);


			LinearLayout lin0 = new LinearLayout(getApplicationContext());
			lin0.setOrientation(LinearLayout.VERTICAL);
			lin0.setBackgroundColor(Color.RED);
			
			TextView faltam = new TextView(getApplicationContext());
			faltam.setText("Faltam");
			faltam.setTextColor(Color.BLACK);
			faltam.setTextSize(18);
			faltam.setGravity(Gravity.CENTER);
			
			TextView qtd = new TextView(getApplicationContext());
			qtd.setText("30");
			qtd.setTextColor(Color.BLACK);
			qtd.setTextSize(18);
			qtd.setGravity(Gravity.CENTER);
			
			TextView dias = new TextView(getApplicationContext());
			dias.setText("dias");
			dias.setTextColor(Color.BLACK);
			dias.setTextSize(18);
			dias.setGravity(Gravity.CENTER);
			
			lin0.addView(faltam);
			lin0.addView(qtd);
			lin0.addView(dias);
			
			LinearLayout lin = new LinearLayout(getApplicationContext());
			lin.setOrientation(LinearLayout.VERTICAL);
			
			TextView proc = new TextView(getApplicationContext());
			proc.setText("Proc. " + listaproc.get(num).numprocesso);
			proc.setTextColor(Color.BLACK);
			proc.setTextSize(17);	    	
			proc.setTypeface(null, Typeface.BOLD);

			TextView info = new TextView(getApplicationContext());
			info.setText(listaproc.get(num).vara+" - "+listaproc.get(num).cidade);
			info.setTextColor(Color.BLACK);
			info.setTextSize(17);	    	
			info.setTypeface(null, Typeface.BOLD);

			TextView info2 = new TextView(getApplicationContext());
			info2.setText(listaproc.get(num).autor+" X "+listaproc.get(num).reu);
			info2.setTextColor(Color.BLACK);
			info2.setTextSize(15);	    	

			lin.addView(proc);
			lin.addView(info);
			lin.addView(info2);

			TextView espaco = new TextView(getApplicationContext());
			espaco.setText("  ");
			espaco.setTextColor(Color.BLACK);
			espaco.setTextSize(15);	

			tableRow1.addView(lin0);
			tableRow1.addView(espaco);
			tableRow1.addView(lin);
			
			tabela.addView(tableRow1);
		}
	}	
	
	public void AdicionarProcesso(){
		
		ImageButton btnAdicionar = (ImageButton) findViewById(R.id.imageAdd);
		
		btnAdicionar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {

				Intent intent = new Intent(ctx,
						Activity_CadProcesso.class);
				startActivity(intent);
				
			}
		});
	}
	
	
	public void VisualizarUsuário(){

	ImageButton btnUser = (ImageButton) findViewById(R.id.imageUser);
	
	btnUser.setOnClickListener(new Button.OnClickListener() {
		public void onClick(View arg0) {
			Intent intent = new Intent(ctx,
					Activity_VisUsuario.class);
			startActivity(intent);
		
		}
	});
	}
}
