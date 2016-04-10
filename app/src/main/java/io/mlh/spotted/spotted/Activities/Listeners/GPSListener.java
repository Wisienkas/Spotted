package io.mlh.spotted.spotted.Activities.Listeners;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import io.mlh.spotted.spotted.Model.User;

/**
 * Created by wisienkas on 4/10/16.
 */
public class GPSListener implements LocationListener {
    @Override
    public void onLocationChanged(Location location) {
        ParseUser user = User.user;
        user.put("location", new ParseGeoPoint(location.getLatitude(), location.getLongitude()));
        user.saveEventually(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null) {
                    Log.e("LOCATION", "Failed to save location on user: " + e.getMessage());
                }
            }
        });
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.i("LOCATION", "Provider Changed, Provider: " + provider + " Status: " + status);
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.i("LOCATION", "Location Provider enabled: " + provider);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.i("LOCATION", "Location Provider disabled: " + provider);
    }
}
