package com.example.sujith.interrupt.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.sujith.interrupt.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Events extends Fragment {


    public Events() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        RelativeLayout relativeLayout = view.findViewById(R.id.Event_frag);
        relativeLayout.setVisibility(View.INVISIBLE);
        return view;
    }

}
