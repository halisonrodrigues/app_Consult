package br.com.appconsult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import br.com.appconsult.cliente.ClienteActivity;
import br.com.appconsult.empresa.EmpresaActivity;

/**
 * @author luciano
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.MAGENTA));*/
		
	}

	public void clickTelaEmpresa(View v) {
		
		Intent clickPaginaEmpresa = new Intent(this, EmpresaActivity.class);
		startActivity(clickPaginaEmpresa);
		
	}

	public void clickTelaCliente(View v) {

		Intent clickPaginaCliente = new Intent(this, ClienteActivity.class);
		startActivity(clickPaginaCliente);

	}

}
