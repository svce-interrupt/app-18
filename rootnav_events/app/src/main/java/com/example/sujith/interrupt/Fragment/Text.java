package com.example.sujith.interrupt.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sujith.interrupt.R;

import org.jetbrains.annotations.Nullable;


public class Text extends Fragment {

    private static final String eText = "text";

    public static Text createFor(String text){
        Text frag = new Text();
        Bundle args = new Bundle();
        args.putString(eText, text);
        frag.setArguments(args);
        return frag;
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        final String text = getArguments().getString(eText);
        TextView textView = view.findViewById(R.id.text);
        textView.setText(text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();

            }
        });

    }


}
