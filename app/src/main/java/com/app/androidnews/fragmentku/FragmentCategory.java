package com.app.androidnews.fragmentku;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.androidnews.CategoryDetail;
import com.app.androidnews.R;

public class FragmentCategory extends Fragment {

    View view;
    TextView business, entertainment, health, science, sports;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_category, container, false);

        business = view.findViewById(R.id.business);
        entertainment = view.findViewById(R.id.entertainment);
        health = view.findViewById(R.id.health);
        science = view.findViewById(R.id.science);
        sports = view.findViewById(R.id.sports);

        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryDetail.class);
                intent.putExtra("business", "business");
                startActivity(intent);
            }
        });

        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryDetail.class);
                intent.putExtra("business", "entertainment");
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryDetail.class);
                intent.putExtra("business", "health");
                startActivity(intent);
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryDetail.class);
                intent.putExtra("business", "science");
                startActivity(intent);
            }
        });

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryDetail.class);
                intent.putExtra("business", "sports");
                startActivity(intent);
            }
        });



        return view;

    }
}
