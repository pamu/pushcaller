package com.android.pushcaller.receiver;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pnagarjuna on 03/05/16.
 */
public class PushCallReceiver extends ParsePushBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent == null) return;
        try {

            JSONObject json = new JSONObject(intent.getExtras().getString(KEY_PUSH_DATA));
            //String currentPhoneNumber = json.getString("current_phone_number");
            JSONObject payload = json;

            if (json.has("alert")) {
                payload = new JSONObject(json.getString("alert"));
            }

            String targetPhoneNumber = payload.getString("target_phone_number");
            Intent dialer = new Intent(Intent.ACTION_CALL);
            dialer.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            dialer.setData(Uri.parse("tel:" + targetPhoneNumber));
            context.startActivity(dialer);

        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
