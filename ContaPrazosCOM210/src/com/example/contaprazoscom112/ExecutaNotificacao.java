package com.example.contaprazoscom112;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Activity que executa quando o usuário selecione a notificação na barra de status
 * 
 * Activity simples que apenas exibe uma mensagem na tela
 * 
 * Aqui é feito o cancelamento da notificação, para fechar a mesma depois de o usuário abrir
 * 
 * @author ricardo
 *
 */
public class ExecutaNotificacao extends Activity {
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		// Cancela a notificação
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		// Para cancelar precisa utilizar o mesmo id que foi utilizado para criar
		nm.cancel(R.string.app_name);

		Intent intent = new Intent(this,
				Activity_ListaProcessos.class);
		startActivity(intent);
		finish();
	}
}
