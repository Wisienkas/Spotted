package io.mlh.spotted.spotted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void gotoMap(View view) {

    }

    public void gotoConfig(View view) {

    }

    public void gotoFriends(View view) {
        startActivity(new Intent(this, FriendActivity.class));
    }
}
