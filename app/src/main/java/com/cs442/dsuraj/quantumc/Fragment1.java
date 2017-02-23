package com.cs442.dsuraj.quantumc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import static com.cs442.dsuraj.quantumc.R.id.imageView;


public class Fragment1 extends Fragment implements View.OnClickListener {

    View rootView;
    ImageView btw1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_tab2, container, false);
        btw1 = (ImageView) rootView.findViewById(imageView);
        btw1.setOnClickListener(this);


        ImageButton button = (ImageButton) rootView.findViewById(R.id.imageButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey wanna watch a movie, Fly Paper, http://www.imdb.com/title/tt1541160/");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        return rootView;
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), Detail2.class);
        intent.putExtra("booktype", 01);
        startActivity(intent);
    }
}
