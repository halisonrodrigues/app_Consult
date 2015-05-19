package br.com.appconsult.empresa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import br.com.appconsult.R;

public class EmpresaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_empresa);

	}

	public void clickCadastroEmpresa(View v) {
		Intent clickAdicaoEmpresa = new Intent(this,
				CadastroEmpresaActivity.class);
		startActivity(clickAdicaoEmpresa);
	}

	public void clickModificarEmpresa(View v) {

	}

	public void clickExcluirEmpresa(View v) {

	}

}
