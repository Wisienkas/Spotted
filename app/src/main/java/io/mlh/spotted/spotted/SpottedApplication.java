package io.mlh.spotted.spotted;

import android.app.Application;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import io.mlh.spotted.spotted.Model.Connections;
import io.mlh.spotted.spotted.Model.User;

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
        Connections.getINSTANCE().update();
    }
}
