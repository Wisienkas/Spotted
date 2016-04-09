package io.mlh.spotted.spotted.Activities.Listeners;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import io.mlh.spotted.spotted.Model.User;

/**
 * Created by wisienkas on 4/9/16.
 */
public class SignupListener implements View.OnClickListener {

    final EditText usernameTextfield;
    final EditText passwordTextfield;
    final Context context;

    public SignupListener(EditText usernameTextfield, EditText passwordTextfield, Context context) {
        this.usernameTextfield = usernameTextfield;
        this.passwordTextfield = passwordTextfield;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        final ParseUser user = new ParseUser();
        String email = usernameTextfield.getText().toString();
        user.setEmail(email);
        user.setUsername(email);
        user.setPassword(passwordTextfield.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null) {
                    if(user.isAuthenticated()) {
                        User.user = user;
                        Toast.makeText(context,
                                "Signed Up!",
                                Toast.LENGTH_SHORT)
                                .show();
                        Log.i("SPOTTED-PARSE", "User Signed up as: " + user.getUsername() + " Session Key: " + user.getSessionToken());
                    }
                } else {
                    Log.e("Not Signed Up!!", e.getMessage());
                    //showSignupError(e);
                }
            }
        });
    }

    @Deprecated
    private void showSignupError(ParseException e) {
        new AlertDialog.Builder(context)
                .setTitle("Signup Failed")
                .setMessage("Signup failed, see Msg: " + e.getMessage())
                .setNeutralButton("Affirmative!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SignupListener.this.passwordTextfield.setText("");
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}
