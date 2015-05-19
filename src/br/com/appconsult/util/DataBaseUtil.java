package br.com.appconsult.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseUtil extends SQLiteOpenHelper {

	/*
	 * Constantes para uso no CORE
	 */
	private static final String nomeDoBanco = "BDAPPCONSULT";
	private static final int versaoDoBanco = 1;

	public DataBaseUtil(Context context) {

		super(context, nomeDoBanco, null, versaoDoBanco);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sqlCreateTababelaUsuario = "CREATE TABLE usuario("
				+ "idUsuario INTEGER PRIMARY KEY," + "senha TEXT" + ")";
		String sqlCreateTababelaProduto = "CREATE TABLE produto("
				+ "codProd INTEGER PRIMARY KEY," + "quant NUMERIC,"
				+ "descr TEXT," + "valorUnit REAL," + "campanha TEXT,"
				+ "fk_codEmp INTEGER" + ")";
		String sqlCreateTabelaPedidoProduto = "CREATE TABLE pedidoProduto("
				+ "id INTEGER PRIMARY KEY," + "fk_numPed INTEGER,"
				+ "fk_codProd INTEGER" + ")";
		String sqlCreateTabelaPedido = "CREATE TABLE pedido ("
				+ "numPed INTEGER PRIMARY KEY," + "dataEntr TEXT,"
				+ "statusPedido BIT," + "fk_idCliente INTEGER" + ")";
		String sqlCreateTabelaEmpresa = "CREATE TABLE empresa("
				+ "codEmp INTEGER PRIMARY KEY," + "nome TEXT," + "custo TEXT"
				+ ")";
		String sqlCreateTabelaContasPagar = "CREATE TABLE contasPagar("
				+ "codConta INTEGER PRIMARY KEY," + "statusConta TEXT,"
				+ "valor REAL," + "dataVenc TEXT," + "descricao TEXT" + ")";
		String sqlCreateTabelaClientes = "CREATE TABLE cliente("
				+ "id INTEGER PRIMARY KEY," + "nome TEXT NOT NULL," + "email TEXT,"
				+ "telefone TEXT NOT NULL," + "cidade TEXT," + "rua TEXT,"
				+ "bairro TEXT" + ")";

		db.execSQL(sqlCreateTababelaUsuario);
		db.execSQL(sqlCreateTababelaProduto);
		db.execSQL(sqlCreateTabelaPedidoProduto);
		db.execSQL(sqlCreateTabelaPedido);
		db.execSQL(sqlCreateTabelaEmpresa);
		db.execSQL(sqlCreateTabelaContasPagar);
		db.execSQL(sqlCreateTabelaClientes);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		String sqlDropTabelaUsuario = "DROP TABLE usuario";
		String sqlDropTabelaProduto = "DROP TABLE produto";
		String sqlDropTabelaPedidoProduto = "DROP TABLE pedidoProduto";
		String sqlDropTabelaPedido = "DROP TABLE pedido";
		String sqlDropTabelaEmpresa = "DROP TABLE empresa";
		String sqlDropTabelaContasPagar = "DROP TABLE contasPagar";
		String sqlDropTabelaCliente = "DROP TABLE cliente";

		db.execSQL(sqlDropTabelaUsuario);
		db.execSQL(sqlDropTabelaProduto);
		db.execSQL(sqlDropTabelaPedidoProduto);
		db.execSQL(sqlDropTabelaPedido);
		db.execSQL(sqlDropTabelaEmpresa);
		db.execSQL(sqlDropTabelaContasPagar);
		db.execSQL(sqlDropTabelaCliente);

		onCreate(db);

	}

	public SQLiteDatabase getConnection() {

		SQLiteDatabase db = getReadableDatabase();

		return db;

	}

}
