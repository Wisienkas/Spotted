package io.mlh.spotted.spotted;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register_Activity extends AppCompatActivity {

    private EditText rName;
    private EditText rEmail;
    private EditText rPassword;
    private Button rButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.rName = (EditText)findViewById(R.id.registerName);
        this.rEmail = (EditText)findViewById(R.id.registerEmail);
        this.rPassword = (EditText)findViewById(R.id.registerPassword);
        this.rButton = (Button) findViewById(R.id.registerButton);

    rButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
/*
            String username = rName.getText().toString().trim();
            String email = rEmail.getText().toString().trim();
            String password = rPassword.getText().toString().trim();

            ParseUser user = new ParseUser();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);/*
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null){
                        // User registered with success
                        Toast.makeText(Register_Activity.this,"Register successful", Toast.LENGTH_LONG).show();

                    } else{
                        // There was an error.
                        Toast.makeText(Register_Activity.this,"There was an error", Toast.LENGTH_LONG).show();
                    }
                }
            });*/

        }
    });
    }
}
