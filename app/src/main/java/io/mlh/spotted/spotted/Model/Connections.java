package io.mlh.spotted.spotted.Model;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by wisienkas on 4/9/16.
 */
public class Connections extends Observable {

    private volatile static Connections INSTANCE = new Connections();

    public static Connections getINSTANCE() {
        return INSTANCE;
    }

    private List<ParseObject> connectionObjects = new ArrayList<>();

    private Connections() {
    }

    public void setList(List<ParseObject> objects) {
        connectionObjects = objects;
        notifyObservers(objects);
    }

    public List<ParseObject> getConnectionObjects() {
        return connectionObjects;
    }

    public void update() {
        ParseQuery<ParseObject> query = new ParseQuery<>("Connection");
        Log.i("PARSE_FETCH", "Starting to find all connections");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (objects == null) {
                    Log.e("PARSE-ERROR", e.getMessage());
                } else {
                    Connections.getINSTANCE().setList(objects);
                    Log.i("PARSE_FETCH", "Found all connections, " + objects.size());
                }
            }
        });
    }
}
