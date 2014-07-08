package com.example.contaprazoscom112;
import java.util.ArrayList;
import java.util.List;

import com.example.contaprazoscom112.R.color;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import android.widget.ViewAnimator;
import android.text.format.Time;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnClickListener;
import android.view.GestureDetector;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.Typeface;

public class Activity_ListaProcessos extends Activity {    
	TableRow flingObj;
	TableLayout mainScreen;
	public int qualprocesso;
	public long id;

	public static Repositorio repositorio;
	public final Context ctx = this;
	private int mYear, mMonth, mDay;
	private final String[] listacorvermelho = { "#790514", "#c10820", "#d90924", "#f3223d","#f55368","#f76c7e","#f88493","#f99da9","#fbb5be","#fcced4","#fde6e9","#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9","#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" ,"#fde6e9" };
	private final String[] listaazul = {"#02141d","#04283a","#063d58", "#085175", "#0b6693", "#23759d", "#3b84a8", "#5493b3", "#6ca3be", "#85b2c9", "#9dc1d3", "#9dc1d3" };
	private final String[] listaamarelo = {"#d2cd0d" ,"#eae40f" ,"#eae40f" ,"#ece626" ,"#eee93e" ,"#f0ec57" ,"#f2ee6f"};

	List<Processo> listaproc = new ArrayList<Processo>();
	String[] listcor;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Time today = new Time(Time.getCurrentTimezone());
		today.setToNow();

		mDay= today.monthDay; 
		mMonth = today.month;              
		mYear  = today.year; 

		repositorio = new Repositorio(this);


		setContentView(R.layout.activity_cnc);
		mainScreen = (TableLayout)findViewById(R.id.tabela_processo);
		CarregarProcessos();

		CarregarCor();
		notificarPrazo();
		CarregarTABELA();
		AdicionarProcesso();
		VisualizarUsuário();
	}

	public void CarregarCor(){
		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);
		String cor = sharedPreferences.getString("COR", "");
		listcor = listacorvermelho;
		if(cor.equals("Vermelho")){
			listcor = listacorvermelho;
		}else if(cor.equals("Amarelo")){
			listcor = listaamarelo;
		}else{
			listcor = listaazul;
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
		for( int num=0; num<listaproc.size(); num++){	
			final TableRow tableRow1 = new TableRow(getApplicationContext());
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


			int prazo = listaproc.get(num).prazo;

			int pdias = listaproc.get(num).publicacaodia;

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


			if(listaproc.get(num).destaque.equals("TRUE")){
				destaque.setChecked(true);
			}else{
				destaque.setChecked(false);
			}


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

			final long idr = listaproc.get(num)._id;
			final int numr = num;
			tableRow1.setOnClickListener(
					new OnClickListener() {

						@Override
						public void onClick( View v ) {
							SavePreferences("idprocesso", ""+idr);
							Intent intent = new Intent(ctx,
									Activity_VisProcesso.class);
							startActivity(intent);
							finish();

						}					
					}		

					);


			id = listaproc.get(num)._id;

			final int numi = num;


			final GestureDetector myGesture = new GestureDetector(this, new MyOnGestureListener());

			tableRow1.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					qualprocesso= numi;
					flingObj = tableRow1;
					return myGesture.onTouchEvent(event);

				}});

			tableRow1.setClickable(true);


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

	class MyOnGestureListener implements OnGestureListener{
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			if (Math.abs(e1.getY() - e2.getY()) > 200) {
				return false;
			}
			//direita para esquerda
			if (e1.getX() - e2.getX() > 200 && Math.abs(velocityX) > 200) {
				flingObj.setBackgroundColor(Color.parseColor("#2da326"));
				((LinearLayout) flingObj.getChildAt(0)).setBackgroundColor(Color.parseColor("#2da326"));
				((LinearLayout) flingObj.getChildAt(2)).setBackgroundColor(Color.parseColor("#2da326"));
				listaproc.get(qualprocesso).status = "CUMPRIDO";
				listaproc.get(qualprocesso)._id = repositorio.atualizarProcesso(listaproc.get(qualprocesso));

				Intent intent = new Intent(ctx,Activity_ListaProcessos.class);
				startActivity(intent);
				finish();
			} 
			//direita para esquerda
			else if (e2.getX() - e1.getX() > 200 && Math.abs(velocityX) > 200) {
				flingObj.setBackgroundColor(Color.parseColor("#8c0606"));
				((LinearLayout) flingObj.getChildAt(0)).setBackgroundColor(Color.parseColor("#8c0606"));
				((LinearLayout) flingObj.getChildAt(2)).setBackgroundColor(Color.parseColor("#8c0606"));
				listaproc.get(qualprocesso).status = "NAOCUMPRIDO";
				listaproc.get(qualprocesso)._id = repositorio.atualizarProcesso(listaproc.get(qualprocesso));
				Intent intent = new Intent(ctx,Activity_ListaProcessos.class);
				startActivity(intent);
				finish();			
			}
			return true;

		}

		@Override
		public void onLongPress(MotionEvent e) {
		}
		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {return false;}
		@Override
		public void onShowPress(MotionEvent e) {}
		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			return false;
		}
		@Override
		public boolean onDown(MotionEvent arg0) {
			return false;
		}

	};

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
		btnUser.setOnClickListener( new OnClickListener() {
			@Override

			public void onClick(View arg0) {
				Intent intent = new Intent(ctx,
						Activity_VisUsuario.class);
				startActivity(intent);
				finish();
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
	// NOTIFICACAO //
	// -----------------------------------------------------------------------------//
	public void notificarPrazo(){
		SharedPreferences sharedPreferences = getSharedPreferences("CoopFam", Activity.MODE_PRIVATE);
		String prazomin = sharedPreferences.getString("NOTIFPRAZO", "");
		if(prazomin.equals("") || prazomin == null){
			prazomin = "2 dias";
		}
		int minimoprazo =Integer.valueOf(prazomin.substring(0, 1));
		int torf=0;
		for( int num=0; num<listaproc.size(); num++){	
			int prazo = listaproc.get(num).prazo;

			int pdias = listaproc.get(num).publicacaodia;

			int qtddias = (pdias-mDay)+prazo;
			if(qtddias<=minimoprazo){ torf = 1; }
		}
		if(torf == 1){
			// Texto com a chamada para a notificação (barra de status)
			String tickerText = "O prazo para um processo chegou!";
			// Detalhes da mensagem, quem enviou e o texto
			CharSequence titulo = "Conta Prazos";
			CharSequence mensagem = "Veja sua lista de processos, você tem prazos a cumprir! - Prazo Mínimo = "+prazomin+".";
			// Exibe a notificação para abrir a RecebeuMensagemActivity
			criarNotificacao(this, tickerText, titulo, mensagem, ExecutaNotificacao.class);
		}
	}
	protected void criarNotificacao(Context context, CharSequence mensagemBarraStatus, CharSequence titulo,CharSequence mensagem, Class<?> activity) {

		// Recupera o serviço do NotificationManager
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		Notification n = new Notification(R.drawable.logo, mensagemBarraStatus, System.currentTimeMillis());

		// PendingIntent para executar a Activity se o usuário selecionar a
		// notificação
		PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, activity), 0);

		// Informações
		n.setLatestEventInfo(this, titulo, mensagem, p);

		// Precisa de permissão: <uses-permission
		// android:name="android.permission.VIBRATE" />
		// espera 100ms e vibra por 250ms, depois espera por 100 ms e vibra por
		// 500ms.
		n.vibrate = new long[] { 100, 250, 100, 500 };

		// id (numero único) que identifica esta notificação
		nm.notify(R.string.app_name, n);
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
	
	// -----------------------------------------------------------------------------//
	// FINALIZANDO //
	// -----------------------------------------------------------------------------//
	@Override
	protected void onDestroy() {
		super.onDestroy();
//		repositorio.fechar();
	}

} 