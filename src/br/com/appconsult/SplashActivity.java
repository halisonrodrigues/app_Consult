package br.com.appconsult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity implements Runnable {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		getActionBar().setIcon(null);

		Handler handler = new Handler();
		handler.postDelayed(this, 5000);

	}

	@Override
	public void run() {

		startActivity(new Intent(this, MainActivity.class));
		finish();

	}

}
