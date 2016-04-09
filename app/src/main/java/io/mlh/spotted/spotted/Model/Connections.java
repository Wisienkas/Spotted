package io.mlh.spotted.spotted.Model;

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
}
