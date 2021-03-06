package com.example.contaprazoscom112;

import java.sql.Date;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

//_id numprocesso vara datapublicacao jornal tribunal cidade expediente titulo autor reu despacho prazo advogado destaque status
//_ID NUMPROCESSO VARA DATAPUBLICACAO JORNAL TRIBUNAL CIDADE EXPEDIENTE TITULO AUTOR REU DESPACHO PRAZO ADVOGADO DESTAQUE STATUS

public class Processo {
	public static String[] colunas = new String[] { Processos._ID, Processos.NUMPROCESSO, Processos.VARA, Processos.PUBLICACAODIA, Processos.PUBLICACAOMES, Processos.PUBLICACAOANO, Processos.JORNAL, Processos.TRIBUNAL, Processos.CIDADE, Processos.EXPEDIENTE, Processos.TITULO, Processos.AUTOR, Processos.REU, Processos.DESPACHO, Processos.PRAZO, Processos.ADVOGADO, Processos.DESTAQUE, Processos.STATUS};
	
	//Pacote do Content Provider. Precisa ser �nico.
	public static final String AUTHORITY = "nome.do.pacote.provider.Processo";
	
	
	public long _id;
	public String numprocesso;
	public String vara;
	public int  publicacaodia  ;
	public int  publicacaomes  ;
	public int  publicacaoano  ;
	public String jornal  ;
	public String tribunal  ;
	public String cidade  ;
	public String expediente  ;
	public String titulo  ;
	public String autor; 
	public String reu;
	public String despacho;
	public int prazo;
	public String advogado;
	public String destaque;
	public String status;
	public Processo() {
	}

	public Processo(String numprocesso,String vara , int  publicacaodia, int  publicacaomes, int  publicacaoano , String jornal, String tribunal, String cidade, String expediente, String titulo, String autor, String reu , String despacho, int prazo, String advogado, String destaque, String status) 
	{
		super();
		this.numprocesso = numprocesso;
		this.vara  = vara;
		this.publicacaodia = publicacaodia;
		this.publicacaomes = publicacaomes;
		this.publicacaoano = publicacaoano;
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
		this.status = status;
	}

	public Processo(long _id, String numprocesso,String vara , int  publicacaodia, int  publicacaomes, int  publicacaoano , String jornal, String tribunal, String cidade, String expediente, String titulo, String autor, String reu , String despacho, int prazo, String advogado, String destaque, String status) 
	{
		super();
		this._id = _id;
		this.numprocesso = numprocesso;
		this.vara  = vara;
		this.publicacaodia = publicacaodia;
		this.publicacaomes = publicacaomes;
		this.publicacaoano = publicacaoano;
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
		this.status = status;
		}
	
	
	public static final class Processos implements BaseColumns {
	
		private Processos() {
		}
	
		
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/Processos");
	
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.Processos";
	
		// Mime Type para um �nica classificacao
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.Processos";
	
		// Ordena��o default para inserir no order by
		
		public static final String DEFAULT_SORT_ORDER = "_id ASC";
		
		
		public static final String _ID = "_id";
		public static final String  NUMPROCESSO   = "numprocesso";
		public static final String  VARA  = "vara";
		public static final String PUBLICACAODIA  = "publicacaodia";
		public static final String PUBLICACAOMES  = "publicacaomes";
		public static final String PUBLICACAOANO  = "publicacaoano";
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
		public static final String STATUS = "status";	
		
		
		
		
		// M�todo que constr�i uma Uri para uma Classifica��o espec�fico, com o seu id
		// A Uri � no formato "content://br.livro.android.provider.item/itens/id"
		public static Uri getUriId(long _id) {
			// Adiciona o id na URI default do /itens
			Uri uriprocesso = ContentUris.withAppendedId(Processos.CONTENT_URI, _id);
			return uriprocesso;
		}
	}
	

	
}


