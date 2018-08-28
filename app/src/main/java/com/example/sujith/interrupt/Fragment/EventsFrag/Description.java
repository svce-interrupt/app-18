package com.example.sujith.interrupt.Fragment.EventsFrag;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.transition.TransitionSet;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sujith.interrupt.Activity.EventActivity;
import com.example.sujith.interrupt.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Description extends Fragment {

    public static String des = null;
    public static String rules = null;

    Bitmap bitmap;
    public Description(){

    }

    public void setDes(String string1,String string2){
        des = string1;
        rules = string2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        RelativeLayout relative = view.findViewById(R.id.real2);
        relative.setClipToOutline(true);
        TextView textView = view.findViewById(R.id.Des);
        textView.setText(des);
        final RelativeLayout relativeLayout = view.findViewById(R.id.rules);
        relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Rules fragment = new Rules();
                fragment.setRules(rules);
                getChildFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_up,R.anim.slide_down)
                        .replace(R.id.rules,new Rules())
                        .commit();

                return true;
            }
        });
        ImageButton imageButton = view.findViewById(R.id.close);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.GONE);
                getChildFragmentManager()
                        .popBackStack();
            }
        });


        return view;
    }


}
