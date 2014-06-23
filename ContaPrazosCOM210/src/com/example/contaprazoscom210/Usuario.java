package com.example.contaprazoscom210;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
//_ID NOMEUSUARIO DATADENASCIMENTO CPF ENDERECO CELULAR EMAIL NUMEROOAB APELIDO SENHA

//_id nomeusuario datadenascimento cpf endereco celular email numerooab apelido senha
public class Usuario {
	public static String[] colunas = new String[] { Usuarios._ID, Usuarios.NOMEUSUARIO, Usuarios.DATADENASCIMENTO, Usuarios.CPF , Usuarios.ENDERECO, Usuarios.CELULAR, Usuarios.EMAIL  , Usuarios.NUMEROOAB, Usuarios.APELIDO, Usuarios.SENHA};
	
	//Pacote do Content Provider. Precisa ser �nico.
	public static final String AUTHORITY = "nome.do.pacote.provider.Usuario";
	
	
	public long _id;
	public String nomeusuario;
	public String datadenascimento;
	public String  cpf ;
	public String endereco ;
	public String celular ;
	public String email ;
	public String numeroOAB ;
	public String apelido ;
	public String senha;
	
	public Usuario() {
	}

	public Usuario(String nomeusuario,String datadenascimento, String  cpf, String endereco , String celular, String email, String numeroOAB, String apelido, String senha) 
	{
		super();
		this.nomeusuario = nomeusuario;
		this.datadenascimento  = datadenascimento;
		this.cpf = cpf;
		this.endereco = endereco;
		this.celular = celular;
		this.email  = email;
		this.numeroOAB   = numeroOAB;
		this.apelido  = apelido;
		this.senha = senha;
			
	}

	public Usuario(long _id, String nomeusuario,String datadenascimento, String  cpf, String endereco , String celular, String email, String numeroOAB, String apelido, String senha) 
	{
		super();
		this._id = _id;
		this.nomeusuario = nomeusuario;
		this.datadenascimento  = datadenascimento;
		this.cpf = cpf;
		this.endereco = endereco;
		this.celular = celular;
		this.email  = email;
		this.numeroOAB   = numeroOAB;
		this.apelido  = apelido;
		this.senha = senha;
			
	}
/**
	 * Classe interna para representar as colunas e ser utilizada por um Content Provider
	 * Filha de BaseColumns que j� define (_id e _count), para seguir o padr�o Android
	 */
	public static final class Usuarios implements BaseColumns {
	
		// N�o pode instanciar esta Classe
		private Usuarios() {
		}
	
		// content://br.livro.android.provider.classificacao/classificacoes
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/Usuarios");
	
		// Mime Type para todas as classificacoes
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.Usuarios";
	
		// Mime Type para um �nica classificacao
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.Usuarios";
	
		// Ordena��o default para inserir no order by
		
		public static final String DEFAULT_SORT_ORDER = "_id ASC";
		
		
		public static final String _ID = "_id";
		public static final String  NOMEUSUARIO  = "nomeusuario";
		public static final String  DATADENASCIMENTO = "datadenascimento";
		public static final String CPF = "cpf";
		public static final String ENDERECO    = "endereco";
		public static final String CELULAR  = "celular";
		public static final String EMAIL  = "email";
		public static final String NUMEROOAB  = "numerooab";
		public static final String APELIDO  = "apelido";
		public static final String SENHA = "senha";
		
		
		
		
		// M�todo que constr�i uma Uri para uma Classifica��o espec�fico, com o seu id
		// A Uri � no formato "content://br.livro.android.provider.item/itens/id"
		public static Uri getUriId(long _id) {
			// Adiciona o id na URI default do /itens
			Uri uriUsuario = ContentUris.withAppendedId(Usuarios.CONTENT_URI, _id);
			return uriUsuario;
		}
	}
	

	@Override
	public String toString() {
		return "Nome: "+nomeusuario+" Data: "+ datadenascimento +" CPF: "+ cpf + " Endereco: "+ endereco + " Celular: "+ celular +" E-mail: "+email+ " Num OAB: "+ numeroOAB + " Apelido: " + apelido + "Senha" + senha;
	}
}

