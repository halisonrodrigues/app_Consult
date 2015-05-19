package br.com.appconsult.empresa;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.appconsult.R;

public class CadastroEmpresaActivity extends Activity {

	EmpresaDAO dao = new EmpresaDAO(this);

	private EditText editTextNome;
	private EditText editTextCusto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro_empresa);

		editTextNome = (EditText) findViewById(R.id.editText_NomeEmpresa);
		editTextCusto = (EditText) findViewById(R.id.editText_Custo);

	}

	public void ClickCadastrarEmpresa(View v) {

		if (editTextNome.getText().toString().equals("")
				|| editTextCusto.getText().toString().equals("")) {

			Toast.makeText(this, "Campos náo preenchidos...", Toast.LENGTH_LONG)
					.show();

		} else {

			Cursor cursor = dao.pesquisaEmpresao(editTextNome.getText()
					.toString());

			if (cursor.moveToFirst()) {

				Toast.makeText(this, "Já existe uma empresa com esse nome...",
						Toast.LENGTH_LONG).show();

			} else {

				Empresa novaEmpresa = new Empresa(editTextNome.getText()
						.toString(), editTextCusto.getText().toString());

				dao.insertEmpresa(novaEmpresa);

				editTextNome.setText("");
				editTextCusto.setText("");

				Toast.makeText(
						this,
						"A empresa " + editTextNome.getText().toString()
								+ " foi cadastrada...", Toast.LENGTH_LONG)
						.show();

			}
		}
	}
}
