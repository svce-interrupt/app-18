package com.example.sujith.minip.Fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sujith.minip.R;

import yalantis.com.sidemenu.interfaces.ScreenShotable;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFrag extends Fragment implements ScreenShotable{


    private Bitmap bitmap;
    private View containerView;

    public FoodFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false);
    }


    @Override
    public void takeScreenShot() {

    }

    @Override
    public Bitmap getBitmap() {

        return null;
    }

}
