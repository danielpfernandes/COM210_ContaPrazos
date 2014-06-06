package com.example.contaprazoscom112;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
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

	List<Processo> listaproc = new ArrayList<Processo>();
	
	@Override
	public void onCreate(Bundle iciBundle) {
		super.onCreate(iciBundle);  
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

			TextView dias = new TextView(getApplicationContext());
			dias.setText("teste");
			dias.setTextColor(Color.BLACK);
			dias.setTextSize(22);
			dias.setBackgroundColor(Color.RED);
			
			LinearLayout lin = new LinearLayout(getApplicationContext());
			lin.setOrientation(LinearLayout.VERTICAL);
			
			TextView proc = new TextView(getApplicationContext());
			proc.setText("Proc. " + listaproc.get(num).numprocesso);
			proc.setTextColor(Color.BLACK);
			proc.setTextSize(16);	    	

			TextView info = new TextView(getApplicationContext());
			info.setText(listaproc.get(num).vara+" - "+listaproc.get(num).cidade);
			info.setTextColor(Color.BLACK);
			info.setTextSize(16);	    	
			

			TextView info2 = new TextView(getApplicationContext());
			info2.setText(listaproc.get(num).autor+" X "+listaproc.get(num).reu);
			info2.setTextColor(Color.BLACK);
			info2.setTextSize(14);	    	

			lin.addView(proc);
			lin.addView(info);
			lin.addView(info2);
			

			tableRow1.addView(dias);
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
				finish();
				
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
			finish();
		}
	});
	}
}
