package com.android.pushcaller.app;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.SaveCallback;

/**
 * Created by pnagarjuna on 03/05/16.
 */
public class PushCaller extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(getApplicationContext(),
                "YvvyFICilXSRtGqLTWMBytIdNb0EnCaJTtvy7lKn",
                "lLu7CDw6bN5cEWwvR45ODQ4xWXr80E7YXTdGbaR6");
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParsePush.subscribeInBackground(
                "push_caller",
                new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e != null)
                            e.printStackTrace();
                    }
                });

    }

}
