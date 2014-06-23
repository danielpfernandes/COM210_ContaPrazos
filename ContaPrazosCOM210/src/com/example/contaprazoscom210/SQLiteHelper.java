package com.example.contaprazoscom210;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class SQLiteHelper extends SQLiteOpenHelper {

	private static final String CATEGORIA = "categoria";

	private String[] scriptSQLCreate;
	private String scriptSQLDelete;

	SQLiteHelper(Context context, String nomeBanco, int versaoBanco, String[] scriptSQLCreate, String scriptSQLDelete) {
		super(context, nomeBanco, null, versaoBanco);

		this.scriptSQLCreate = scriptSQLCreate;
		this.scriptSQLDelete = scriptSQLDelete;

	}

	// Criar novo banco...
	@Override	
	public void onCreate(SQLiteDatabase db) {
		Log.i(CATEGORIA, "Criando banco com sql");
		int qtdeScripts = scriptSQLCreate.length;

		// Executa cada sql passado como parâmetro
		for (int i = 0; i < qtdeScripts; i++) {
			String sql = scriptSQLCreate[i];
			Log.i(CATEGORIA, sql);
			// Cria o banco de dados executando o script de criação
			db.execSQL(sql);
		}
	}

	// Mudou a versão...
	@Override	
	public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {
		Log.w(CATEGORIA, "Atualizando da versão " + versaoAntiga + " para " + novaVersao + ". Todos os registros serão deletados.");
		Log.i(CATEGORIA, scriptSQLDelete);

		// Deleta as tabelas...
		db.execSQL(scriptSQLDelete);

		// Cria novamente...
		onCreate(db);
	}
}