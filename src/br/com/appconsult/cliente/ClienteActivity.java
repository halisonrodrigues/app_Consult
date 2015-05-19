package br.com.appconsult.cliente;

import br.com.appconsult.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ClienteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cliente);
	}

	public void clickCadastroCliente(View v) {

		Intent clickCadastroCliente = new Intent(this,
				CadastroClienteActivity.class);
		startActivity(clickCadastroCliente);

	}

	public void clickExcluirCliente(View v) {

	}

}
