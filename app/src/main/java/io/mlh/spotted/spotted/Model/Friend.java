package io.mlh.spotted.spotted.Model;

import android.location.Location;

/**
 * Created by wisienkas on 4/9/16.
 */
public class Friend {
    private final String name;
    private Location location;
    private String bluetoothId;

    public Friend(String name, Location location, String bluetoothId) {
        this.name = name;
        this.location = location;
        this.bluetoothId = bluetoothId;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getBluetoothId() {
        return bluetoothId;
    }

    public void setBluetoothId(String bluetoothId) {
        this.bluetoothId = bluetoothId;
    }
}
