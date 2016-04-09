package io.mlh.spotted.spotted.Activities.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import io.mlh.spotted.spotted.Model.Friend;
import io.mlh.spotted.spotted.R;

/**
 * Created by wisienkas on 4/9/16.
 */
public class FriendListAdapter extends ArrayAdapter<Friend> {

    private final Context context;


    public FriendListAdapter(Context context, List<Friend> friendList) {
        super(context, 0, friendList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.friend_list_row, parent, false);
        TextView name = (TextView) rowView.findViewById(R.id.friend_name_field);
        name.setText(getItem(position).getName());
        return rowView;
    }
}
