package com.example.sujith.interrupt.Fragment.EventsFrag;


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
public class PitchPerfect extends Fragment {


    public PitchPerfect() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pitch_perfect, container, false);
        RelativeLayout relativeLayout = view.findViewById(R.id.pp);
       relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               getChildFragmentManager()
                       .beginTransaction()
                       .setCustomAnimations(R.anim.slide_up,R.anim.slide_down)
                       .replace(R.id.pp,new Description())
                       .commit();
               return true;
           }
       });

        return view;
    }

}
