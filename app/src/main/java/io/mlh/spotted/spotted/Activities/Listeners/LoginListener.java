package io.mlh.spotted.spotted.Activities.Listeners;

import android.view.View;
import android.widget.EditText;

import com.parse.ParseUser;

/**
 * Created by wisienkas on 4/9/16.
 */
public class LoginListener implements View.OnClickListener {

    final EditText usernameTextfield;
    final EditText passwordTextfield;

    public LoginListener(EditText usernameTextfield, EditText passwordTextfield) {
        this.usernameTextfield = usernameTextfield;
        this.passwordTextfield = passwordTextfield;
    }

    @Override
    public void onClick(View v) {
        
    }
}
