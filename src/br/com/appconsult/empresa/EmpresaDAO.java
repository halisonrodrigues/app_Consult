package br.com.appconsult.empresa;

import java.util.ArrayList;
import java.util.List;

import br.com.appconsult.util.DataBaseUtil;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class EmpresaDAO extends DataBaseUtil {
	
	SQLiteDatabase db;

	public EmpresaDAO(Context context) {
		
		super(context);
		
	}

	public void insertEmpresa(Empresa empresa) {
		
		ContentValues cv = new ContentValues();
		
		db = getConnection();
		
		cv.put("nome", empresa.getNome());
		cv.put("custo", empresa.getCusto());
		db.insert("empresa", null, cv);
		db.close();
		
	}

	public List<Empresa> selectTodasAsEmpresas() {
		
		List<Empresa> listaEmpresa = new ArrayList<Empresa>();
		String sqlSelectTodasEmpresas = "SELECT * FROM empresa";
		db = getConnection();
		Cursor c = db.rawQuery(sqlSelectTodasEmpresas, null);

		if (c.moveToFirst()) {
			
			do {
				
				Empresa empresa = new Empresa();
				empresa.setNome(c.getString(0));
				empresa.setCusto(c.getString(1));

				listaEmpresa.add(empresa);
				
			} while (c.moveToNext());
			
		}

		db.close();

		return listaEmpresa;
	}
	
	public Cursor pesquisaEmpresao(String nomeEmpresa) {
		
		db = getConnection();

		Cursor curso = db.rawQuery("SELECT * FROM empresa WHERE nome = '"
				+ nomeEmpresa + "'", null);

		return curso;

	}

}
