package io.mlh.spotted.spotted;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
/*
        this.usernameField = (EditText) findViewById(R.id.username_input);
        this.passwordField = (EditText) findViewById(R.id.password_input);
        this.loginButton = (Button) findViewById(R.id.login_button);
        this.signupButton = (Button) findViewById(R.id.signup_redirect);

        this.loginButton.setOnClickListener(
                new LoginListener(this.usernameField, this.passwordField, getApplicationContext()));
        this.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_Activity.this, Signup_Activity.class);
                //intent.putExtra("username", emailField.getText().toString());
                startActivity(intent);

        });
        // Redirect to Signup activity
        //this.signupRedirect.setOnClickListener();  */  }

}
