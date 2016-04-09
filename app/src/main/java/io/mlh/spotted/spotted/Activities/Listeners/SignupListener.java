package io.mlh.spotted.spotted.Activities.Listeners;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

    final EditText sName;
    final EditText sEmail;
    final EditText sPassword;
    final Context context;

    public SignupListener(EditText sName, EditText sEmail, EditText sPassword, Context context) {
        this.sName = sName;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        final ParseUser user = new ParseUser();
        String name = sName.getText().toString();
        String email = sEmail.getText().toString();
        user.setUsername(name);
        user.setEmail(email);
        user.setUsername(email);
        user.setPassword(sPassword.getText().toString());

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

    // TODO Fix this piece, it chrashes the app
    @Deprecated
    private void showSignupError(ParseException e) {
        new AlertDialog.Builder(context)
                .setTitle("Signup Failed")
                .setMessage("Signup failed, see Msg: " + e.getMessage())
                .setNeutralButton("Affirmative!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SignupListener.this.sPassword.setText("");
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}
