package io.mlh.spotted.spotted;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import io.mlh.spotted.spotted.Activities.Listeners.SignupListener;

public class Signup_Activity extends AppCompatActivity {

    private EditText passwordField;
    private EditText emailField;
    private EditText usernameField;
    private Button signupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.usernameField = (EditText) findViewById(R.id.signup_name);
        this.emailField = (EditText) findViewById(R.id.signup_email);
        this.passwordField = (EditText) findViewById(R.id.signup_password);
        this.signupButton = (Button) findViewById(R.id.signup_btn);

        this.signupButton.setOnClickListener(
                new SignupListener(this.usernameField, this.emailField, this.passwordField, getApplicationContext()));
    }
}
