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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.w3c.dom.Text;

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

    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        output = (TextView) findViewById(R.id.output);
        makeMyListView();
        // Will unfocus EditText, so keyboard is not shown initially
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Connections.getINSTANCE().addObserver(this);
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
        adapter.clear();
        for (ParseObject po : data) {
            if(po.getString("user1").equalsIgnoreCase(User.user.getString("username"))) {
                adapter.add(new Friend(po.getString("user2"), null, null));
            } else if(po.getString("user2").equalsIgnoreCase(User.user.getString("username"))) {
                adapter.add(new Friend(po.getString("user1"), null, null));
            }
        }
    }

    public void addFriends(View view) {
        output.setText("Searching to add friend");
        final String name = ((EditText) findViewById(R.id.friend_add_field)).getText().toString();
        if(name.equalsIgnoreCase(User.user.getString("username"))) {
            // You cannot link to yourself
            return;
        }
        ParseQuery<ParseUser> query = new ParseQuery<>("_User");
        //query.whereEqualTo("username", name);
        query.findInBackground(new FindCallback<ParseUser>() {
               @Override
               public void done(List<ParseUser> objects, ParseException e) {
                   if(objects != null && objects.size() > 0) {
                       ParseObject parseObject = new ParseObject("Connection");
                       parseObject.put("user1", User.user.getUsername());
                       parseObject.put("user2", name);
                       parseObject.saveInBackground(new SaveCallback() {
                           @Override
                           public void done(ParseException e) {
                               if(e == null) {
                                   Log.i("PARSE-SAVE", "Saved new Connection");
                                   Connections.getINSTANCE().update();
                                   output.setText("Friend Added");
                               } else {
                                   Log.e("PARSE-SAVE", e.getMessage());
                               }
                           }
                       });
                   } else if(e != null) {
                       Log.e("PARSE-QUERY", e.getMessage());
                   } else {
                       Log.i("PARSE-QUERY", "Found nothing");
                   }
               }
           }
        );
    }
}
