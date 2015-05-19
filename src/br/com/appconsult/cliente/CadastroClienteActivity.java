package br.com.appconsult.cliente;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.appconsult.R;

public class CadastroClienteActivity extends Activity {

	ClienteDAO dao = new ClienteDAO(this);

	private EditText editTextNome;
	private EditText editTextTelefone;
	private EditText editTextEmail;
	private EditText editTextRua;
	private EditText editTextBairro;
	private EditText editTextCidade;

	private Long id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro_cliente);

		Intent intent = getIntent();
		Bundle params = intent.getExtras();

		if (params != null) {

			iniciaCampos();

			preparaAlteracao(params.getString("nomeCliente"));

			params = null;

		} else {

			iniciaCampos();

		}

	}

	public void clickCadastroCliente(View v) {

		Intent intent = new Intent(this, ClienteActivity.class);

		if (editTextNome.getText().toString().equals("")
				|| editTextTelefone.getText().toString().equals("")) {

			Toast.makeText(this, "Campos são obrigatorios não preenchidos.", Toast.LENGTH_LONG)
					.show();

		} else {

			Cursor cursor = dao.pesquisaCliente(editTextNome.getText()
					.toString());

			if (cursor.moveToFirst()) {

				Toast.makeText(this, "Já existe um cliente cadastrado.",
						Toast.LENGTH_LONG).show();

			} else {

				Cliente novoCliente = new Cliente(editTextNome.getText()
						.toString(), editTextTelefone.getText().toString(),
						editTextEmail.getText().toString(), editTextRua
								.getText().toString(), editTextBairro.getText()
								.toString(), editTextCidade.getText()
								.toString(), id);

				Long l = dao.insertCliente(novoCliente);

				if (l != -1) {

					if (id != null) {

						limparCampos();

						Toast.makeText(
								this,
								"Cliente " + editTextNome.getText().toString()
										+ " atualizado com sucesso.",
								Toast.LENGTH_LONG).show();

						startActivity(intent);

					} else {

						limparCampos();

						Toast.makeText(
								this,
								"Cliente " + editTextNome.getText().toString()
										+ " cadastrado com sucesso.",
								Toast.LENGTH_LONG).show();

						startActivity(intent);

					}

				} else {

					if (id != null) {

						Toast.makeText(
								this,
								"Cliente " + editTextNome.getText().toString()
										+ " não atualizado.",
								Toast.LENGTH_LONG).show();

					} else {

						Toast.makeText(
								this,
								"Cliente " + editTextNome.getText().toString()
										+ " não cadastrado.",
								Toast.LENGTH_LONG).show();

					}

				}

			}
		}
	}

	public void limparCampos() {

		editTextNome.setText("");
		editTextTelefone.setText("");
		editTextEmail.setText("");
		editTextRua.setText("");
		editTextBairro.setText("");
		editTextCidade.setText("");

	}

	private void preparaAlteracao(String nomeCliente) {

		Cursor c = dao.pesquisaCliente(nomeCliente);

		c.moveToFirst();

		id = (long) c.getInt(0);

		editTextNome.setText(c.getString(1));
		editTextEmail.setText(c.getString(2));
		editTextTelefone.setText(c.getString(3));
		editTextRua.setText(c.getString(4));
		editTextBairro.setText(c.getString(5));
		editTextCidade.setText(c.getString(6));

	}

	private void iniciaCampos() {

		editTextNome = (EditText) findViewById(R.id.editText_Nome);
		editTextTelefone = (EditText) findViewById(R.id.editText_Telefone);
		editTextEmail = (EditText) findViewById(R.id.editText_Email);
		editTextRua = (EditText) findViewById(R.id.editText_Rua);
		editTextBairro = (EditText) findViewById(R.id.editText_Bairro);
		editTextCidade = (EditText) findViewById(R.id.editText_Cidade);

	}

}
