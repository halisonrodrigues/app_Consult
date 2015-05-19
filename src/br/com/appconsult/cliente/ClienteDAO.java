package br.com.appconsult.cliente;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.appconsult.util.DataBaseUtil;

public class ClienteDAO extends DataBaseUtil {

	SQLiteDatabase db;

	public ClienteDAO(Context context) {

		super(context);

	}

	public List<String> listarClientes() {

		List<String> listaCliente = new ArrayList<String>();

		db = getConnection();

		String sqlSelectTodosClientes = "SELECT nome FROM cliente";

		Cursor c = db.rawQuery(sqlSelectTodosClientes, null);

		if (c.moveToFirst()) {

			do {

				listaCliente.add(c.getString(0));

			} while (c.moveToNext());

		}

		c.close();

		db.close();

		return listaCliente;

	}

	public Long insertCliente(Cliente cliente) {
		
		Long retorno = null;

		db = getConnection();

		ContentValues cv = new ContentValues();

		cv.put("nome", cliente.getnomeDoCliente());
		cv.put("telefone", cliente.getTelefone());
		cv.put("email", cliente.getEmail());
		cv.put("rua", cliente.getRua());
		cv.put("bairro", cliente.getBairro());
		cv.put("cidade", cliente.getCidade());

		if (cliente.getId() != null) {

			String id = Long.toString(cliente.getId());

			retorno = (long) db.update("cliente", cv, "id = ?", new String[] { id });
			db.close();

		} else {

			retorno = db.insert("cliente", null, cv);
			db.close();

		}
		
		return retorno;

	}

	public Cursor pesquisaCliente(String nomeCliente) {

		db = getConnection();

		Cursor cursor = db.rawQuery("SELECT * FROM cliente WHERE nome = '"
				+ nomeCliente + "'", null);

		return cursor;

	}

}
