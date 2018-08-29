package com.example.sujith.interrupt.Fragment.EventsFrag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.InputDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sujith.interrupt.Activity.EventActivity;
import com.example.sujith.interrupt.R;



public class Rules extends Fragment{

    public static String rules = null;


    public Rules() {
        // Required empty public constructor
    }


    public void setRules(String string){
        rules = string;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rules, container, false);
        TextView textView = view.findViewById(R.id.Rules);
        textView.setText(rules);
        RelativeLayout relative = view.findViewById(R.id.real3);
        relative.setClipToOutline(true);
        final RelativeLayout relativeLayout = view.findViewById(R.id.rela3);


        ImageButton imageButton = view.findViewById(R.id.close);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    relativeLayout.setVisibility(View.GONE);
                }
        });

        return view;
    }

}
