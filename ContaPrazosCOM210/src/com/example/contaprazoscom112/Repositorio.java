package com.example.contaprazoscom112;


import java.util.ArrayList;
import java.util.List;

import com.example.contaprazoscom112.Processo.Processos;
import com.example.contaprazoscom112.Usuario.Usuarios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

public class Repositorio {
	// Nome da Categoria
	private static final String CATEGORIA = "categoria";
	// Nome do banco
	private static final String NOME_BANCO = "contaprazossqlite";
	// Nome das tabelas
	public static final String NOME_TABELA_1 = "Usuario";
	public static final String NOME_TABELA_2 = "Processo";
	// Controle de versão
	private static final int VERSAO_BANCO = 1;
	// Script para fazer drop na tabela
	private static final String SCRIPT_DATABASE_DELETE = "DROP TABLE IF EXISTS Usuario; DROP TABLE IF EXISTS Processo; ";
	// Cria a tabela
	private static final String[] SCRIPT_DATABASE_CREATE = new String[] {
		"create table Usuario( _id integer primary key autoincrement, nomeusuario text, datadenascimento text, cpf text, endereco text, celular text, email text, numeroOAB text, apelido text, senha text);", 
		"create table Processo ( _id integer primary key autoincrement, numprocesso text, vara text, datapublicacao text, jornal text, tribunal text, cidade text, expediente text, titulo text, autor text, reu text, despacho text, advogado  text);",
	}
	;

	// Classe utilitária para abrir, criar, e atualizar o banco de dados
	private SQLiteHelper dbHelper;
	// Ponteiro para o Banco de Dados
	protected SQLiteDatabase db;
	// Construtor do Repositório
	public Repositorio(Context ctx) {
		// Abre o banco de dados já existente 
		//db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);

		// Criar utilizando um script SQL
		dbHelper = new SQLiteHelper(ctx, Repositorio.NOME_BANCO, Repositorio.VERSAO_BANCO, Repositorio.SCRIPT_DATABASE_CREATE, Repositorio.SCRIPT_DATABASE_DELETE);

		// abre o banco no modo escrita para poder alterar também
		db = dbHelper.getWritableDatabase();
	}
	protected Repositorio() {
		// Apenas para criar uma subclasse...
	}
	///-----------------------------------------------------------------------------//
	// SALVAR                                                                       //
	//-----------------------------------------------------------------------------//
	public long salvarUsuario(Usuario objeto) {
		long _id = objeto._id;
		if (_id != 0) {
			atualizarUsuario(objeto);
		} else {
			_id = inserirUsuario(objeto);
		}
		return _id;
	}
	public long salvarProcesso(Processo objeto) {
		long _id = objeto._id;

		if (_id != 0) {
		atualizarProcesso(objeto);
		} else {
		_id = inserirProcesso(objeto);
		}
		return _id;
	}
	//-----------------------------------------------------------------------------//
	// INSERIR  1                                                                  //
	//-----------------------------------------------------------------------------//	
	public long inserirUsuario(Usuario objeto) {
		ContentValues values = new ContentValues();
		values.put(Usuarios.NOMEUSUARIO, objeto.nomeusuario);
		values.put(Usuarios.DATADENASCIMENTO, objeto.datadenascimento);
		values.put(Usuarios.CPF  , objeto.cpf  );
		values.put(Usuarios.ENDERECO   , objeto.endereco  );
		values.put(Usuarios.CELULAR  , objeto.celular  );
		values.put(Usuarios.EMAIL   , objeto.email  );
		values.put(Usuarios.NUMEROOAB  , objeto.numeroOAB );
		values.put(Usuarios.APELIDO   , objeto.apelido  );
		values.put(Usuarios.SENHA  , objeto.senha );
		long _id =inserirUsuario(values);
		return _id;
	}
	public long inserirProcesso(Processo objeto) {
		ContentValues values = new ContentValues();
		values.put(Processos.NUMPROCESSO, objeto.numprocesso);
		values.put(Processos.VARA  , objeto.vara);
		values.put(Processos.DATAPUBLICACAO  , objeto.datapublicacao);
		values.put(Processos.JORNAL  , objeto.jornal);
		values.put(Processos.TRIBUNAL  , objeto.tribunal);
		values.put(Processos.CIDADE   , objeto.cidade);
		values.put(Processos.EXPEDIENTE   , objeto.expediente);
		values.put(Processos.TITULO, objeto.titulo);
		values.put(Processos.AUTOR, objeto.autor);
		values.put(Processos.REU, objeto.reu);
		values.put(Processos.DESPACHO , objeto.despacho);
		values.put(Processos.ADVOGADO    , objeto.advogado);
		
		long _id =inserirProcesso(values);
		
		
		return _id;
	}
	//-----------------------------------------------------------------------------//
	// INSERIR   2                                                                 //
	//-----------------------------------------------------------------------------//
	public long inserirUsuario(ContentValues valores) {
		long _id = db.insert(NOME_TABELA_1, "", valores);
		return _id;
	}
	public long inserirProcesso(ContentValues valores) {
		long _id = db.insert(NOME_TABELA_2, "", valores);
		return _id;
	}
	//-----------------------------------------------------------------------------//
	// ATUALIZA 1                                                                  //
	//-----------------------------------------------------------------------------//
	public int atualizarUsuario(Usuario objeto) {
		ContentValues values = new ContentValues();
		values.put(Usuarios.NOMEUSUARIO, objeto.nomeusuario);
		values.put(Usuarios.DATADENASCIMENTO, objeto.datadenascimento);
		values.put(Usuarios.CPF  , objeto.cpf  );
		values.put(Usuarios.ENDERECO   , objeto.endereco  );
		values.put(Usuarios.CELULAR  , objeto.celular  );
		values.put(Usuarios.EMAIL   , objeto.email  );
		values.put(Usuarios.NUMEROOAB  , objeto.numeroOAB );
		values.put(Usuarios.APELIDO   , objeto.apelido  );
		values.put(Usuarios.SENHA  , objeto.senha );

		String _id = String.valueOf(objeto._id);

		String where = Usuarios._ID + "=?";
		String[] whereArgs = new String[] { _id };

		int count = atualizarUsuario(values, where, whereArgs);

		return count;
	}
	public int atualizarProcesso(Processo objeto) {
		ContentValues values = new ContentValues();

		values.put(Processos.NUMPROCESSO, objeto.numprocesso);
		values.put(Processos.VARA  , objeto.vara);
		values.put(Processos.DATAPUBLICACAO  , objeto.datapublicacao);
		values.put(Processos.JORNAL  , objeto.jornal);
		values.put(Processos.TRIBUNAL  , objeto.tribunal);
		values.put(Processos.CIDADE   , objeto.cidade);
		values.put(Processos.EXPEDIENTE   , objeto.expediente);
		values.put(Processos.TITULO, objeto.titulo);
		values.put(Processos.AUTOR, objeto.autor);
		values.put(Processos.REU, objeto.reu);
		values.put(Processos.DESPACHO , objeto.despacho);
		values.put(Processos.ADVOGADO    , objeto.advogado);
		
		String _id = String.valueOf(objeto._id);

		String where = Processos._ID + "=?";
		String[] whereArgs = new String[] { _id };

		int count = atualizarProcesso(values, where, whereArgs);

		return count;
	}
		//-----------------------------------------------------------------------------//
	// ATUALIZA 2                                                                  //
	//-----------------------------------------------------------------------------//
	public int atualizarUsuario(ContentValues valores, String where, String[] whereArgs) {
		int count = db.update(NOME_TABELA_1, valores, where, whereArgs);
		Log.i(CATEGORIA, "Atualizou [" + count + "] registros");
		return count;
	}
	public int atualizarProcesso(ContentValues valores, String where, String[] whereArgs) {
		int count = db.update(NOME_TABELA_2, valores, where, whereArgs);
		Log.i(CATEGORIA, "Atualizou [" + count + "] registros");
		return count;
	}
	
	//-----------------------------------------------------------------------------//
	// BUSCAS                                                                      //
	//-----------------------------------------------------------------------------//
/*
	public Usuario buscarUsuario(long _id) {
		// select * from objeto where _id=?
		Cursor c = db.query(true, NOME_TABELA_1, ObjRasProd.colunas, RasProdutos._IDRASPROD + "=" + _idrasprod, null, null, null, null, null);

		if (c.getCount() > 0) {

			// Posicinoa no primeiro elemento do cursor
			c.moveToFirst();

			ObjRasProd objeto = new ObjRasProd();

			// Lê os dados
			objeto._idrasprod = c.getLong(0);
			objeto.rasproduto = c.getString(1);
			objeto.raspotencialhistorico = c.getString(2);
			c.close();
			return objeto;
		}
		c.close();		
		return null;
	}
	*/
	
	
	/*
	public ObjProdutosComerciais buscarProd(long _id) {
		// select * from objeto where _id=?
		Cursor c = db.query(true, NOME_TABELA_4, ObjProdutosComerciais.colunas, Produtos._IDPROD + "=" + _id, null, null, null, null, null);

		if (c.getCount() > 0) {

			// Posicinoa no primeiro elemento do cursor
			c.moveToFirst();

			ObjProdutosComerciais objeto = new ObjProdutosComerciais();

			// Lê os dados
			objeto._idprod = c.getLong(0);
			objeto._idext = c.getInt(1);
			objeto.produto = c.getString(2);
			objeto.potencialhistorico = c.getString(3);
			c.close();
			return objeto;
		}
		c.close();		
		return null;
	}
	
	*/
	
	
	//-----------------------------------------------------------------------------//
	// LISTAS                                                                      //
	//-----------------------------------------------------------------------------//
	public List<Processo> listarProcesso(String _id) {
		List<Processo> objetos = new ArrayList<Processo>();


		try {
			// Idem a: SELECT _id,atributo1,atributo2,atributo3 from OBJETO where nome = ?
			Cursor c = db.query(NOME_TABELA_2, Processo.colunas, null, null, null, null, null);

			if (c.moveToFirst()) {

				// Loop até o final
				do {
					Processo objeto = new Processo();
					objetos.add(objeto);

					// recupera os atributos de objeto
					objeto._id = c.getLong(0);
					objeto.numprocesso = c.getString(1);
					objeto.vara = c.getString(2);
					objeto.datapublicacao = c.getString(3);
					objeto.jornal = c.getString(4);
					objeto.tribunal = c.getString(5);
					objeto.cidade = c.getString(6);
					objeto.expediente = c.getString(7);
					objeto.titulo = c.getString(8);
					objeto.autor = c.getString(9);
					objeto.reu= c.getString(10);
					objeto.despacho= c.getString(11);
					objeto.advogado= c.getString(12);

				} while (c.moveToNext());
			}		
			c.close();		

		} catch (SQLException e) {
			Log.e(CATEGORIA, "Erro ao buscar o objeto: " + e.toString());

			return null;
		}	

		return objetos;
	}
	
	//-----------------------------------------------------------------------------//
	// FINALIZAND                                                                  //
	//-----------------------------------------------------------------------------//
	public void apagarUsuario(){
		db.execSQL("DROP TABLE IF EXISTS Usuario;");
		db.execSQL("create table Usuario( _id integer primary key autoincrement, nomeusuario text, datadenascimento text, cpf text, endereco text, celular text, email text, numeroOAB text, apelido text, senha text);" 
				);
	}
	
	public void apagarProcesso(){
		db.execSQL("DROP TABLE IF EXISTS Processo;");
		db.execSQL("create table Processo ( _id integer primary key autoincrement, numprocesso text, vara text, taxa text, datapublicacao text, jornal text, tribunal text, cidade text, expediente text, titulo text, autor text, reu text, despacho text, advogado  text);"
		);
	}
	
	public Cursor query(SQLiteQueryBuilder queryBuilder, String[] projection, String selection, String[] selectionArgs,
			String groupBy, String having, String orderBy) {
		Cursor c = queryBuilder.query(this.db, projection, selection, selectionArgs, groupBy, having, orderBy);

		return c;
	}
	public void fechar() {
		// fecha o banco de dados
		if (db != null) {
			db.close();
		}		
		if (dbHelper != null) {
			dbHelper.close();
		}
	}	
}