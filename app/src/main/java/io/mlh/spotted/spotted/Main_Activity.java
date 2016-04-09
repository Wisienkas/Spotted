package io.mlh.spotted.spotted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Main_Activity extends AppCompatActivity {

    private EditText passwordField;
    private EditText usernameField; // Email used here
    private Button loginButton;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.usernameField = (EditText) findViewById(R.id.username_input);
        this.passwordField = (EditText) findViewById(R.id.password_input);
        this.loginButton = (Button) findViewById(R.id.login_button);
        this.signupButton = (Button) findViewById(R.id.signup_button);

        // Adding Signup
        //this.loginButton.setOnClickListener();
    }
}
