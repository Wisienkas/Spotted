package io.mlh.spotted.spotted;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import io.mlh.spotted.spotted.Activities.adapters.FriendListAdapter;
import io.mlh.spotted.spotted.Activities.fragment.MutualFriendFragment;
import io.mlh.spotted.spotted.Activities.listView.FriendListView;
import io.mlh.spotted.spotted.Model.Connections;
import io.mlh.spotted.spotted.Model.Friend;
import io.mlh.spotted.spotted.Model.User;

public class FriendActivity extends Activity implements Observer {

    private ListView listView;
    private FriendListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        makeMyListView();
        // Will unfocus EditText, so keyboard is not shown initially
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private void makeMyListView() {
        List<Friend> list = new ArrayList<>();

        adapter = new FriendListAdapter(getApplicationContext(), list);
        insertIntoAdapter(Connections.getINSTANCE().getConnectionObjects());
        listView = (ListView) findViewById(R.id.friend_listview);
        listView.setAdapter(adapter);
    }

    @Override
    public void update(Observable observable, Object data) {
        insertIntoAdapter((List<ParseObject>) data);
        adapter.notifyDataSetChanged();
        Log.i("PARSE-UPDATE", "WE UPDATE LISTVIEW!!");
    }

    private void insertIntoAdapter(List<ParseObject> data) {
        for (ParseObject po : data) {
            if(po.getString("user1").equalsIgnoreCase(User.user.getString("username"))) {
                adapter.add(new Friend(po.getString("user2"), null, null));
            } else if(po.getString("user2").equalsIgnoreCase(User.user.getString("username"))) {
                adapter.add(new Friend(po.getString("user1"), null, null));
            }
        }
    }
}
