package com.example.contaprazoscom112;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

//_id numprocesso vara datapublicacao jornal tribunal cidade expediente titulo autor reu despacho prazo advogado destaque
//_ID NUMPROCESSO VARA DATAPUBLICACAO JORNAL TRIBUNAL CIDADE EXPEDIENTE TITULO AUTOR REU DESPACHO PRAZO ADVOGADO DESTAQUE

public class Processo {
	public static String[] colunas = new String[] { Processos._ID, Processos.NUMPROCESSO, Processos.VARA, Processos.DATAPUBLICACAO, Processos.JORNAL, Processos.TRIBUNAL, Processos.CIDADE, Processos.EXPEDIENTE, Processos.TITULO, Processos.AUTOR, Processos.REU, Processos.DESPACHO, Processos.PRAZO, Processos.ADVOGADO, Processos.DESTAQUE};
	
	//Pacote do Content Provider. Precisa ser único.
	public static final String AUTHORITY = "nome.do.pacote.provider.Processo";
	
	
	public long _id;
	public String numprocesso;
	public String vara;
	public String  datapublicacao  ;
	public String jornal  ;
	public String tribunal  ;
	public String cidade  ;
	public String expediente  ;
	public String titulo  ;
	public String autor; 
	public String reu;
	public String despacho;
	public String prazo;
	public String advogado;
	public String destaque;
	public Processo() {
	}

	public Processo(String numprocesso,String vara , String  datapublicacao , String jornal, String tribunal, String cidade, String expediente, String titulo, String autor, String reu , String despacho, String prazo, String advogado, String destaque) 
	{
		super();
		this.numprocesso = numprocesso;
		this.vara  = vara;
		this.datapublicacao = datapublicacao;
		this.jornal  = jornal;
		this.tribunal  = tribunal;
		this.cidade   = cidade;
		this.expediente = expediente;
		this.titulo = titulo;
		this.autor  = autor;
		this.reu = reu; 
		this.despacho = despacho; 
		this.prazo = prazo;
		this.advogado = advogado;
		this.destaque = destaque;
	}

	public Processo(long _id, String numprocesso,String vara , String  datapublicacao , String jornal, String tribunal, String cidade, String expediente, String titulo, String autor, String reu , String despacho, String prazo,String advogado, String destaque) 
	{
		super();
		this._id = _id;
		this.numprocesso = numprocesso;
		this.vara  = vara;
		this.datapublicacao = datapublicacao;
		this.jornal  = jornal;
		this.tribunal  = tribunal;
		this.cidade   = cidade;
		this.expediente = expediente;
		this.titulo = titulo;
		this.autor  = autor;
		this.reu = reu; 
		this.despacho = despacho; 
		this.prazo = prazo;
		this.advogado = advogado;
		this.destaque = destaque;
			
	}
	
	
	public static final class Processos implements BaseColumns {
	
		private Processos() {
		}
	
		
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/Processos");
	
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.Processos";
	
		// Mime Type para um única classificacao
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.Processos";
	
		// Ordenação default para inserir no order by
		
		public static final String DEFAULT_SORT_ORDER = "_id ASC";
		
		
		public static final String _ID = "_id";
		public static final String  NUMPROCESSO   = "numprocesso";
		public static final String  VARA  = "vara";
		public static final String DATAPUBLICACAO  = "datapublicacao";
		public static final String JORNAL     = "jornal";
		public static final String TRIBUNAL   = "tribunal";
		public static final String CIDADE  = "cidade";
		public static final String EXPEDIENTE   = "expediente";
		public static final String TITULO   = "titulo";
		public static final String AUTOR = "autor";
		public static final String REU = "reu";
		public static final String DESPACHO = "despacho";
		public static final String PRAZO = "prazo";
		public static final String ADVOGADO = "advogado";
		public static final String DESTAQUE = "destaque";	
		
		
		
		
		// Método que constrói uma Uri para uma Classificação específico, com o seu id
		// A Uri é no formato "content://br.livro.android.provider.item/itens/id"
		public static Uri getUriId(long _id) {
			// Adiciona o id na URI default do /itens
			Uri uriprocesso = ContentUris.withAppendedId(Processos.CONTENT_URI, _id);
			return uriprocesso;
		}
	}
	

	
}


