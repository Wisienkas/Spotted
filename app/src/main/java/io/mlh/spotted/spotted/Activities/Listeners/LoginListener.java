package io.mlh.spotted.spotted.Activities.Listeners;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import io.mlh.spotted.spotted.Model.User;

/**
 * Created by wisienkas on 4/9/16.
 */
public class LoginListener implements View.OnClickListener {

    private final EditText usernameTextfield;
    private final EditText passwordTextfield;
    private final Context context;

    public LoginListener(EditText usernameTextfield, EditText passwordTextfield, Context context) {
        this.usernameTextfield = usernameTextfield;
        this.passwordTextfield = passwordTextfield;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        ParseUser.logInInBackground(
                this.usernameTextfield.getText().toString(),
                this.passwordTextfield.getText().toString(),
                new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            User.user = user;
                            Toast.makeText(context,
                                    "Logged in!",
                                    Toast.LENGTH_SHORT)
                                    .show();
                            Log.i("SPOTTED-PARSE", "User Logged in as: " + user.getUsername() + " Session Key: " + user.getSessionToken());
                        }
                    }
                });
    }
}
