package io.mlh.spotted.spotted.Activities.Listeners;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
                    }
                } else {

                }
            }
        });
    }

    public static class SignupErrorDialog extends DialogFragment {

        public ParseException e;
        public EditText passwordTextfield;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            CharSequence msg = "Signup failed, see Msg: " + (e == null ? "UNKNWON" : e.getMessage());
            builder.setMessage(msg)
                    .setNeutralButton("Affirmative!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            passwordTextfield.setText("");
                        }
                    });
            return builder.create();
        }
    }
}
