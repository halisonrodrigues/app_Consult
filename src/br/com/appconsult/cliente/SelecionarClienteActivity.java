package br.com.appconsult.cliente;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SelecionarClienteActivity extends ListActivity implements
		OnItemClickListener {
	
	ClienteDAO dao = new ClienteDAO(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, dao.listarClientes()));
		
		ListView listView = getListView();

		listView.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		TextView textView = (TextView) view;
		
		Bundle params = new Bundle();
        Intent intent = new Intent(this, CadastroClienteActivity.class);
        String nome = (String) textView.getText();
        params.putString("nomeCliente", nome);
        intent.putExtras(params);

		String mensagem = "Cliente selecionado: " + textView.getText();

		Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT)
				.show();

		startActivity(intent);

	}
}
