package com.app.androidnews.fragmentku;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.androidnews.R;
import com.app.androidnews.adapter.MyAdapter;
import com.app.androidnews.retrofitconfig.GetJsonAll;
import com.app.androidnews.retrofitconfig.RetrofitConfigToJson;
import com.app.androidnews.retrofitjson.News;
import com.app.androidnews.retrofitjson.NewsList;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment {

    GetJsonAll getJsonAll;
    List<News> newsList;
    String title, description;

    RecyclerView recycler_view;
    MyAdapter myAdapter;
    GridLayoutManager gm;

    View view;

    SpinKitView spinKitView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        spinKitView = view.findViewById(R.id.spin_kit);
        recycler_view = view.findViewById(R.id.recycler_view);
        gm = new GridLayoutManager(getContext(), 2);
        recycler_view.setLayoutManager(gm);
        newsList = new ArrayList<>();
        myAdapter = new MyAdapter(getContext(), newsList);
        recycler_view.setAdapter(myAdapter);

        getJsonAll = RetrofitConfigToJson.getResponses();

        getJsonAll.getNewsList("id", "94dbfe81124e4f6eaa34583005e20cb0").enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                Log.d("berhasil", response + "");

                spinKitView.setVisibility(View.VISIBLE);
                if (response.isSuccessful()){

                    spinKitView.setVisibility(View.GONE);

                    newsList = response.body().getArticles();

                    title = newsList.get(0).getTitle();
                    description = newsList.get(0).getDescription();
                    Log.d("titleBerita", "Judul: " + title + " " +  "Deskriptis: " + description);

                    myAdapter = new MyAdapter(getContext(), newsList);
                    recycler_view.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.d("gagal", t + "");
            }
        });

        return view;

    }
}
