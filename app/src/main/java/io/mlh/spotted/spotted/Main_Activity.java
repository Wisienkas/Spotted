package io.mlh.spotted.spotted;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.Parse;

import io.mlh.spotted.spotted.Activities.Listeners.GPSListener;
import io.mlh.spotted.spotted.Activities.Listeners.LoginListener;
import io.mlh.spotted.spotted.Activities.callback.ActivityLink;

public class Main_Activity extends Activity implements ActivityLink {

    /**
     * Will Decide how often the gps updates can happen at the fastest
     * in milliseconds
     */
    private final long GPS_MIN_TIME_UPDATE = 100 * 1000;
    /**
     * The minimum distance in meters the phone has to move according
     * to the gps in order to trigger an update
     */
    private final long GPS_MIN_DISTANCE_UPDATE = 25;

    private EditText passwordField;
    private EditText usernameField; // Email used here
    private Button loginButton;
    private Button signupButton;
    private LocationManager locationManager;
    private GPSListener gpsListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.usernameField = (EditText) findViewById(R.id.username_input);
        this.passwordField = (EditText) findViewById(R.id.password_input);
        this.loginButton = (Button) findViewById(R.id.login_button);
        this.signupButton = (Button) findViewById(R.id.signup_redirect);

        this.loginButton.setOnClickListener(
                new LoginListener(this.usernameField, this.passwordField, this));
        this.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_Activity.this, Signup_Activity.class);
                //intent.putExtra("username", emailField.getText().toString());
                startActivity(intent);
            }
        });
        // Redirect to Signup activity
        //this.signupRedirect.setOnClickListener();
    }

    @Override
    public Context fetchContext() {
        return this;
    }

    @Override
    public void startActivity() {
        startActivity(new Intent(this, MenuActivity.class));
//        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        Criteria criteria = new Criteria();
//        criteria.setAccuracy(Criteria.ACCURACY_MEDIUM);
//        gpsListener = new GPSListener();
//
//        if (!(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
//            locationManager.requestLocationUpdates(
//                    GPS_MIN_TIME_UPDATE,
//                    GPS_MIN_DISTANCE_UPDATE,
//                    criteria,
//                    gpsListener,
//                    Looper.getMainLooper());
//            startActivity(new Intent(this,  MenuActivity.class));
//        }
    }

}
