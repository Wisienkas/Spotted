package io.mlh.spotted.spotted;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.mlh.spotted.spotted.Activities.Listeners.LoginListener;

public class Main_Activity extends AppCompatActivity {


    private EditText usernameField;
    private EditText passwordField;
    private Button loginButton;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.loginButton = (Button) findViewById(R.id.login_button);
        this.signupButton = (Button) findViewById(R.id.signup_redirect);
        this.usernameField = (EditText)findViewById(R.id.login_name) ;
        this.passwordField = (EditText)findViewById(R.id.login_password) ;


        this.loginButton.setOnClickListener(
                new LoginListener(this.usernameField, this.passwordField, getApplicationContext()));
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
}
