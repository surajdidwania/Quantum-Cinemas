package com.cs442.dsuraj.quantumc;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Fragment3 extends Fragment implements View.OnClickListener {
    ImageView btw3;
    ImageButton img;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab4, container, false);
        btw3 = (ImageView) rootView.findViewById(R.id.imageView30);
        btw3.setOnClickListener(this);
        img = (ImageButton) rootView.findViewById(R.id.imageButton30);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey wanna watch a movie, Avengers, http://www.imdb.com/title/tt2395427/?ref_=nv_sr_2");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        return rootView;
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), Detail2.class);
        intent.putExtra("booktype", 03);
        startActivity(intent);
    }
}
