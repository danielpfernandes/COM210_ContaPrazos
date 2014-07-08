package com.example.contaprazoscom112;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
 
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
 
public class PDF  extends Activity {
 
     //yasmin 
	public final Context ctx = this;
	//
	
    private Button b;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        
        //activity_main foi trocado por activity_pdf
         
        b= (Button)findViewById(R.id.btngerarpdf);        
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                createPDF();
 
            }
        });
         
    }
 
     
    public void createPDF()
    {
        Document doc = new Document();
         
         
         try {
               // String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator +"droidText";
                
                File dir = new File(Environment.getExternalStorageDirectory()
        				+ File.separator + "droidText");;
                    if(!dir.exists())
                        dir.mkdirs();
 
                Log.d("PDFCreator", "PDF Path: " + Environment.getExternalStorageDirectory()
        				+ File.separator + "droidText");
                 
                     
                File file = new File(dir, "sample.pdf");
                FileOutputStream fOut = new FileOutputStream(file);
      
                PdfWriter.getInstance(doc, fOut);
                  
                //open the document
                doc.open();
                 
                 
                Paragraph p1 = new Paragraph("Hi! I am generating my first PDF using DroidText");
                Font paraFont= new Font(Font.COURIER);
                p1.setAlignment(Paragraph.ALIGN_CENTER);
                p1.setFont(paraFont);
                 
                 //add paragraph to document    
                 doc.add(p1);
                 
                 Paragraph p2 = new Paragraph("This is an example of a simple paragraph");
                 Font paraFont2= new Font(Font.COURIER,14.0f,Color.GREEN);
                 p2.setAlignment(Paragraph.ALIGN_CENTER);
                 p2.setFont(paraFont2);
                  
                 doc.add(p2);
                  
                 ByteArrayOutputStream stream = new ByteArrayOutputStream();
                 Bitmap bitmap = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.and);
                 bitmap.compress(Bitmap.CompressFormat.JPEG, 100 , stream);
                 Image myImg = Image.getInstance(stream.toByteArray());
                 myImg.setAlignment(Image.MIDDLE);
                 
                 //add image to document
                 doc.add(myImg);
                 
                 //set footer
                 Phrase footerText = new Phrase("This is an example of a footer");
                 HeaderFooter pdfFooter = new HeaderFooter(footerText, false);
                 doc.setFooter(pdfFooter);
                 
 
                 
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
			
		case R.id.menu_pdf:
			intent = new Intent(ctx,
					PDF.class);

			startActivity(intent);
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}

