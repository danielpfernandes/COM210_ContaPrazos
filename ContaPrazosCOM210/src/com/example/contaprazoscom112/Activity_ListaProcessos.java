package com.example.contaprazoscom112;


import java.util.ArrayList;
import java.util.List;

import com.example.contaprazoscom112.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
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
	private final String[] listacorvermelho = { "#790514", "#c10820", "#d90924", "#f3223d","#f55368","#f76c7e","#f88493","#f99da9","#fbb5be","#fcced4","#fde6e9","#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9","#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" };
	private final String[] listaazul = {"#02141d","#04283a","#063d58", "#085175", "#0b6693", "#23759d", "#3b84a8", "#5493b3", "#6ca3be", "#85b2c9", "#9dc1d3", "#9dc1d3" };
	private final String[] listaamarelo = {"#d2cd0d" ,"#eae40f" ,"#eae40f" ,"#ece626" ,"#eee93e" ,"#f0ec57" ,"#f2ee6f"};

	List<Processo> listaproc = new ArrayList<Processo>();
	String[] listcor;
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

		CarregarCor();
		CarregarTABELA();
		AdicionarProcesso();
		VisualizarUsuário();
	}

	public void CarregarCor(){
		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);
		String cor = sharedPreferences.getString("COR", "");
		Toast.makeText(ctx, "COR:" + cor, 1).show();
		listcor = listacorvermelho;
		 if(cor.equals("Azul")){
			listcor = listaazul;
		}else if(cor.equals("Amarelo")){
			listcor = listaamarelo;
		}else{
			listcor = listacorvermelho;
		}

	}
	public void CarregarProcessos(){
		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);
		List<Processo> ListaProcesso;
		if(sharedPreferences.getString("LISTARDESTAQUE", "").equals("TRUE")){
			((TextView) findViewById(R.id.texttituloproc)).setText("          Destaques       ");
			ListaProcesso = repositorio.listarProcessoDestaques(String.valueOf(1));
		}else{
			((TextView) findViewById(R.id.texttituloproc)).setText("          Processos       ");
			ListaProcesso = repositorio.listarProcesso(String.valueOf(1));
		}

		for(int i=0; i<ListaProcesso.size(); i++){	
			listaproc.add(ListaProcesso.get(i));
		}
	}

	public void CarregarTABELA() {
		TableLayout tabela = (TableLayout) findViewById(R.id.tabela_processo);
		tabela.removeAllViews();
		TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.FILL_PARENT);
		TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,Gravity.RIGHT | Gravity.CENTER_VERTICAL);
		tabela.setLayoutParams(tableParams);
		CarregarProcessos();

		for(int num=0; num<listaproc.size(); num++){	
			TableRow tableRow1 = new TableRow(getApplicationContext());
			tableRow1.setLayoutParams(tableParams);


			LinearLayout lin0 = new LinearLayout(getApplicationContext());
			lin0.setOrientation(LinearLayout.VERTICAL);
			String color = listcor[num];
			lin0.setBackgroundColor(Color.parseColor(color));

			TextView faltam = new TextView(getApplicationContext());
			faltam.setText("Faltam");
			faltam.setTextColor(Color.BLACK);
			faltam.setTextSize(18);
			faltam.setGravity(Gravity.CENTER);


			int prazo = Integer.parseInt(listaproc.get(num).prazo);

			int index = listaproc.get(num).datapublicacao.indexOf("/");
			int pdias = Integer.parseInt(listaproc.get(num).datapublicacao.substring(0, index));

			int qtddias = (pdias-mDay)+prazo;


			TextView qtd = new TextView(getApplicationContext());
			qtd.setText(String.valueOf(qtddias));

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

			final CheckBox destaque = new CheckBox(getApplicationContext());
			destaque.setButtonDrawable(R.drawable.custom_destaque);




			TextView espaco2 = new TextView(getApplicationContext());
			espaco2.setText("                        ");
			espaco2.setTextColor(Color.BLACK);
			espaco2.setTextSize(15);	

			tableRow1.addView(lin0);
			tableRow1.addView(espaco);
			tableRow1.addView(lin);
			tableRow1.addView(espaco2);
			tableRow1.addView(destaque);


			tabela.addView(tableRow1);

			final long id = listaproc.get(num)._id;



			tableRow1.setOnClickListener( new OnClickListener() {
				@Override
				public void onClick( View v ) {
					SavePreferences("idprocesso", ""+id);
					Intent intent = new Intent(ctx,
							Activity_VisProcesso.class);
					startActivity(intent);

				}
			} );




			final int numi = num;
			destaque.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					if(destaque.isChecked()){
						listaproc.get(numi).destaque = "TRUE";
						listaproc.get(numi)._id = repositorio.atualizarProcesso(listaproc.get(numi));
					}
					if(!destaque.isChecked()){
						listaproc.get(numi).destaque = "FALSE";
						listaproc.get(numi)._id = repositorio.atualizarProcesso(listaproc.get(numi));
					}

				}


			});




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
		btnUser.setOnClickListener( new OnClickListener() {
			@Override

			public void onClick(View arg0) {
				Intent intent = new Intent(ctx,
						Activity_VisUsuario.class);
				startActivity(intent);

			}
		});
	}

	private void SavePreferences(String key, String value) {
		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}



	// -----------------------------------------------------------------------------//
	// MENU //
	// -----------------------------------------------------------------------------//
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

	// -----------------------------------------------------------------------------//
	// FINALIZANDO //
	// -----------------------------------------------------------------------------//

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//repositorio.fechar();
	}


}
