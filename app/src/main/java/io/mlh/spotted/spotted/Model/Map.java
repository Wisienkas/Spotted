package io.mlh.spotted.spotted.Model;

import android.location.Location;

import java.util.List;

/**
 * Created by wisienkas on 4/9/16.
 */
public class Map {
    private List<SignificantThing> SignificantThings;
    private Location userLocation;
    private List<Friend> friends;

    public Map() {
    }

    public List<SignificantThing> getSignificantThings() {
        return SignificantThings;
    }

    public void setSignificantThings(List<SignificantThing> significantThings) {
        SignificantThings = significantThings;
    }

    public Location getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(Location userLocation) {
        this.userLocation = userLocation;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
}
