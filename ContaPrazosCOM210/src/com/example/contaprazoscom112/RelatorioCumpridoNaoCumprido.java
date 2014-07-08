package com.example.contaprazoscom112;


import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.codec.Base64.InputStream;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RelatorioCumpridoNaoCumprido  extends Activity {


	public final Context ctx = this;
	public static Repositorio repositorio;
	int n = 0;
	//LISTAS
	List<Processo> cumpridos = new ArrayList<Processo>();
	List<Processo> naocumpridos = new ArrayList<Processo>();

	//MES E ANO
	private final String[] listaanos = { "1995", "1996", "1997", "1998", "1999", "2000", 
			"2001", "2002", "2003", "2004", "2005","2006", "2007", "2008", "2009", "2010", 
			"2011", "2012", "2013", "2014"};	

	private final String[] listames = { "janeiro", "Fevereiro",
			"Março", "Abril", "Maio", "junho", "Julho", "Agosto", 
			"Setembro", "Outubro", "Novembro", "Dezembro"};	

	int ano, mes;
	int cumprido, naocumprido;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pdf);
		repositorio = new Repositorio(this);


		Spinner ano = (Spinner) findViewById(R.id.spinnerano);
		ArrayAdapter<String> anoarray = new ArrayAdapter<String>(this,
				R.layout.spinner_custom, listaanos);
		anoarray.setDropDownViewResource(R.layout.spinner_list_custom);
		ano.setAdapter(anoarray);



		int spinnerPosition = anoarray.getPosition("2014");

		//set the default according to value
		ano.setSelection(spinnerPosition);

		Spinner mes = (Spinner) findViewById(R.id.spinnerMes);
		ArrayAdapter<String> mesarray = new ArrayAdapter<String>(this,
				R.layout.spinner_custom, listames);
		mesarray.setDropDownViewResource(R.layout.spinner_list_custom);
		mes.setAdapter(mesarray);


		//	String Grafico = "http://www.paivafernandes.com.br/contaprazos/grafico.php?i="+cumprido+"&a="+naocumprido;
		//String Grafico = "data:image/jpeg;base64,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";
		//Drawable drawable = LoadImageFromWebOperations(Grafico);
		//imgView.setImageDrawable(drawable);


		Button b= (Button)findViewById(R.id.btngerarpdf);        
		b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				StringToInt();
				CarregarProcessosCumpridos();
				Toast.makeText(ctx, "C= "+cumprido + "NC"+naocumprido, 1).show();
				Log.i("CUMPRIDO",""+cumprido);
				Log.i("NAOCUMPRIDO",""+naocumprido);
				createPDF();
			}
		});

	}

	public void StringToInt(){
		Integer iano = ((Spinner) findViewById(R.id.spinnerano))
				.getSelectedItemPosition();

		switch (iano) {

		case 0:
			ano = 1995;
			break;
		case 1:
			ano = 1996;
			break;
		case 2:
			ano = 1997;
			break;
		case 3:
			ano = 1998;
			break;
		case 4:
			ano = 1999;
			break;
		case 5:
			ano = 2000;
			break;
		case 6:
			ano = 2001;
			break;
		case 7:
			ano = 2002;
			break;
		case 8:
			ano = 2003;
			break;
		case 9:
			ano = 2004;
			break;
		case 10:
			ano = 2005;
			break;
		case 11:
			ano = 2006;
			break;
		case 12:
			ano = 2007;
			break;
		case 13:
			ano = 2008;
			break;
		case 14:
			ano = 2009;
			break;
		case 15:
			ano = 2010;
			break;
		case 16:
			ano =2011;
			break;
		case 17:
			ano = 2012;
			break;
		case 18:
			ano = 2013;
			break;
		case 19:
			ano = 2014;
			break;
		}
		Integer imes = ((Spinner) findViewById(R.id.spinnerMes))
				.getSelectedItemPosition();

		switch (imes) {

		case 0:
			mes = 1;
			break;
		case 1:
			mes = 2;
			break;
		case 2:
			mes = 3;
			break;
		case 3:
			mes = 4;
			break;
		case 4:
			mes = 5;
			break;
		case 5:
			mes = 6;
			break;
		case 6:
			mes = 7;
			break;
		case 7:
			mes = 8;
			break;
		case 8:
			mes = 9;
			break;
		case 9:
			mes = 10;
			break;
		case 10:
			mes = 11;
			break;
		case 11:
			mes = 12;
			break;

		}

	}

	public void CarregarProcessosCumpridos(){
		List<Processo> Cumpridos;
		List<Processo> NaoCumpridos;
		Cumpridos = repositorio.listarProcessoPorMes("CUMPRIDO", mes, ano);
		NaoCumpridos = repositorio.listarProcessoPorMes("NAPCUMPRIDO", mes, ano);
		cumprido = repositorio.ContarProcessos("CUMPRIDO", mes, ano);
		naocumprido = repositorio.ContarProcessos("NAPCUMPRIDO", mes, ano);

		for(int i=0; i<Cumpridos.size(); i++){	
			cumpridos.add(Cumpridos.get(i));
		}

		for(int i=0; i<NaoCumpridos.size(); i++){	
			naocumpridos.add(NaoCumpridos.get(i));
		}
	}

	public void createPDF()
	{

		Document doc = new Document();


		try {
			// String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator +"droidText";

			File dir = new File(Environment.getExternalStorageDirectory() + File.separator + "ContaPrazos");
			if (!dir.exists()) {
				dir.mkdir();
			}
			Log.d("PDFCreator", "PDF Path: " + Environment.getExternalStorageDirectory()
					+ File.separator + "ContaPrazos");


			File file = new File(dir, "rel"+n+".pdf");
			n++;
			FileOutputStream fOut = new FileOutputStream(file);

			PdfWriter.getInstance(doc, fOut);

			//open the document
			doc.open();
			//set header
			Phrase headerText = new Phrase("Relatório de processos cumpridos e não cumpridos\n------------------------------------\n");
			HeaderFooter pdfHeader = new HeaderFooter(headerText, false);
			doc.setHeader(pdfHeader);


			Paragraph proccum = new Paragraph("Processos Cumpridos\n");
			Font paraFontproccum= new Font(Font.COURIER,20.0f,Color.GREEN);
			proccum.setAlignment(Paragraph.ALIGN_CENTER);
			proccum.setFont(paraFontproccum);
			doc.add(proccum);


			Paragraph a = new Paragraph("Número do processo - Data de publicação");
			Font paraFonta= new Font(Font.COURIER,16.0f,Color.GREEN);
			a.setAlignment(Paragraph.ALIGN_CENTER);
			a.setFont(paraFonta);
			doc.add(a);

			for(int num=0; num<cumpridos.size(); num++){	
				Paragraph p2 = new Paragraph(cumpridos.get(num).numprocesso + " - "+new StringBuilder().append(cumpridos.get(num).publicacaodia).append("/").append(cumpridos.get(num).publicacaomes).append("/").append(cumpridos.get(num).publicacaoano).append(" "));
				Font paraFont2= new Font(Font.COURIER,14.0f,Color.GREEN);
				p2.setAlignment(Paragraph.ALIGN_LEFT);
				p2.setFont(paraFont2);
				doc.add(p2);
			}
			Paragraph procncum = new Paragraph("Processos Não Cumpridos\n");
			Font paraFontprocncum= new Font(Font.COURIER,20.0f,Color.GREEN);
			procncum.setAlignment(Paragraph.ALIGN_CENTER);
			procncum.setFont(paraFontprocncum);
			doc.add(procncum);

			Paragraph b = new Paragraph("Número do processo - Data de publicação");
			Font paraFontb= new Font(Font.COURIER,16.0f,Color.GREEN);
			b.setAlignment(Paragraph.ALIGN_CENTER);
			b.setFont(paraFontb);
			doc.add(b);

			for(int num=0; num<naocumpridos.size(); num++){	
				Paragraph p2 = new Paragraph(naocumpridos.get(num).numprocesso 
						+ " - "+new StringBuilder().append(naocumpridos.get(num).publicacaodia).append("/").append(naocumpridos.get(num).publicacaomes).append("/").append(naocumpridos.get(num).publicacaoano).append(" "));
				Font paraFont2= new Font(Font.COURIER,14.0f,Color.GREEN);
				p2.setAlignment(Paragraph.ALIGN_LEFT);
				p2.setFont(paraFont2);
				doc.add(p2);
			}

			Paragraph d = new Paragraph(" ");
			Font paraFontd= new Font(Font.COURIER,16.0f,Color.GREEN);
			d.setAlignment(Paragraph.ALIGN_CENTER);
			d.setFont(paraFontd);
			doc.add(d);

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			Bitmap bitmap = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.user);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100 , stream);
			Image myImg = Image.getInstance(stream.toByteArray());
			myImg.setAlignment(Image.MIDDLE);

			//add image to document
			doc.add(myImg);

			//set footer
			Phrase footerText = new Phrase("Engenharia de Software - 2014");
			HeaderFooter pdfFooter = new HeaderFooter(footerText, false);
			doc.setFooter(pdfFooter);

			//close doc
			doc.close();

			Toast.makeText(ctx, "Relatório criado com sucesso na pasta ContaPrazos", 1).show();

		} catch (DocumentException de) {
			Log.e("PDFCreator", "DocumentException:" + de);
		} catch (IOException e) {
			Log.e("PDFCreator", "ioException:" + e);
		} 
		finally
		{
			doc.close();
		}

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
/*
private Drawable LoadImageFromWebOperations(String url)
  {
      try
      {
          InputStream is = (InputStream) new URL(url).getContent();
          Drawable d = Drawable.createFromStream(is, "src name");
          return d;
      }catch (Exception e) {
          System.out.println("Exc="+e);
          return null;
      }
  }
public void imagem(String urlImagem){

	try {

		URL url             = new URL(urlImagem);
		URLConnection con   = url.openConnection(); 

		DataInputStream dis = new DataInputStream(con.getInputStream());
		byte[] fileData     = new byte[con.getContentLength()];

		for (int x = 0; x < fileData.length; x++) {
			fileData[x] = dis.readByte();
		}

		dis.close(); 

		FileOutputStream fos = new FileOutputStream(new File("grafico.png"));
		fos.write(fileData);
		fos.close();    

	}catch(MalformedURLException m) {
		System.out.println(m);
	}catch(IOException io) {
		System.out.println(io);
	}

}

 */

