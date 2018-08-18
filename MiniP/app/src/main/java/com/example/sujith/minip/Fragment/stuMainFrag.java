package com.example.sujith.minip.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sujith.minip.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class stuMainFrag extends Fragment {


    public stuMainFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_stu_main, container, false);
    }

}
