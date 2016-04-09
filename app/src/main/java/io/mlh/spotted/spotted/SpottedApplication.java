package io.mlh.spotted.spotted;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by wisienkas on 4/9/16.
 */
public class SpottedApplication extends Application {

    private final String APP_ID = "dhWVec7EUkNRq8u8toIYd8G7TxfQ7gIbJFai2C6v";
    private final String CLIENT_KEY = "x998YdeUY7KY7rIYziq3ydF6wLr05jcXKQwqtnHl";

    public SpottedApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, APP_ID, CLIENT_KEY);
    }
}
