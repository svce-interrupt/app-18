package com.example.sujith.interrupt.Fragment.EventsFrag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sujith.interrupt.R;
import com.jgabrielfreitas.core.BlurImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PitchPerfect extends Fragment {


    public PitchPerfect() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pitch_perfect, container, false);
        BlurImageView blurImageView = view.findViewById(R.id.blurbg);
        blurImageView.setBlur(15);

        return view;
    }

}
