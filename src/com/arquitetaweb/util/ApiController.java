package com.arquitetaweb.util;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class ApiController {
	private Context context;

	public ApiController(Context context) {
		this.context = context;
	}

	public void sincronizar(String action) {
		new SincronizarDados().execute(action);
	}

	private class SincronizarDados extends AsyncTask<String, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(String... params) {
			return SincronizarConsumo(params[0]);
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			Toast.makeText(context, "Enviado", Toast.LENGTH_LONG).show();
		}

		private Void SincronizarConsumo(String action) {
			GetApi api = new GetApi("192.168.10.20");
			// String retorno = api.getFromApi("tempo");
			api.getFromApi(action);
			return null;
		}
	}
}
