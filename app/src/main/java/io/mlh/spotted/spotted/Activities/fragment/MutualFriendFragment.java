package io.mlh.spotted.spotted.Activities.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.mlh.spotted.spotted.Activities.adapters.FriendListAdapter;
import io.mlh.spotted.spotted.Model.Friend;
import io.mlh.spotted.spotted.R;

/**
 * Created by wisienkas on 4/9/16.
 */
public class MutualFriendFragment extends Fragment {

    private ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.friend_list_view, container, false);

        makeMyListView(fragment);

        return fragment;
    }

    private void makeMyListView(View view) {
        List<Friend> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Friend("friend " + i, null, null));
        }
        FriendListAdapter adapter = new FriendListAdapter(view.getContext(), list);
        listView = (ListView) view.findViewById(R.id.friend_list_view);
        listView.setAdapter(adapter);
    }
}
