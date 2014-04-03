package com.arquitetaweb.opengate;

import com.arquitetaweb.opengate.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

public class OpenGateIntentReceiver extends BroadcastReceiver {

	private static int clickCount = 0;

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(
				"com.arquitetaweb.intent.action.CHANGE_PICTURE")) {
			updateWidgetPictureAndButtonListener(context);
		}
	}

	private void updateWidgetPictureAndButtonListener(Context context) {

		Toast.makeText(context, "Open Gate!!!", Toast.LENGTH_LONG).show();

		RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
				R.layout.widget_opengate);
		remoteViews.setImageViewResource(R.id.widget_image, getImageToSet());

		// REMEMBER TO ALWAYS REFRESH YOUR BUTTON CLICK LISTENERS!!!
		remoteViews.setOnClickPendingIntent(R.id.widget_image,
				OpenGateProvider.buildButtonPendingIntent(context));

		OpenGateProvider.pushWidgetUpdate(context.getApplicationContext(),
				remoteViews);
	}

	private int getImageToSet() {
		clickCount++;
		return clickCount % 2 == 0 ? R.drawable.open : R.drawable.close;
	}
}
