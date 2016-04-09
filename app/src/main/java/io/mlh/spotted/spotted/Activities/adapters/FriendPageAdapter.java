package io.mlh.spotted.spotted.Activities.adapters;

import android.app.Application;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import io.mlh.spotted.spotted.Activities.listView.FriendListView;

/**
 * Created by wisienkas on 4/9/16.
 */
public class FriendPageAdapter extends PagerAdapter {

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View result = new FriendListView(container.getContext());
        switch (position){
            case 0:
                break;
            case 1:
                break;
            default:
                break;
        }
        return result;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
