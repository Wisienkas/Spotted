package io.mlh.spotted.spotted;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Page_Fragment extends android.support.v4.app.Fragment {

    TextView textView1;
    TextView textView2;

    public Page_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        textView2 = (TextView)view.findViewById(R.id.textView2);
        textView1 = (TextView)view.findViewById(R.id.textView);
        Bundle bundle = getArguments();

        switch(bundle.getInt("count")){
            case 1: textView1.setText(R.string.tutorial_1_1);
                textView2.setText(R.string.tutorial_1_2);
                break;
            case 2: textView1.setText(R.string.tutorial_2_1);
                textView2.setText(R.string.tutorial_2_2);
                break;
            case 3: textView1.setText(R.string.tutorial_3_1);
                textView2.setText(R.string.tutorial_3_2);
                break;
        }
        //String message = Integer.toString(bundle.getInt("count"));
        //textView.setText("This is the " + message + "Swipe View Page..");
        return view;
    }

}
