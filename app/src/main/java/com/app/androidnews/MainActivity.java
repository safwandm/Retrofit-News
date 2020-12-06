package com.app.androidnews;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.app.androidnews.adapter.MyAdapter;
import com.app.androidnews.fragmentku.FragmentAbout;
import com.app.androidnews.fragmentku.FragmentCategory;
import com.app.androidnews.fragmentku.FragmentHome;
import com.app.androidnews.retrofitconfig.GetJsonAll;
import com.app.androidnews.retrofitconfig.RetrofitConfigToJson;
import com.app.androidnews.retrofitjson.News;
import com.app.androidnews.retrofitjson.NewsList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        fragmentClick(new FragmentHome());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int userId = menuItem.getItemId();
        Fragment fragment = null;

        switch (userId){

            case R.id.home:
                fragment = new FragmentHome();
                break;

            case R.id.category:
                fragment = new FragmentCategory();
                break;

            case R.id.about:
                fragment = new FragmentAbout();
                break;

        }

        return fragmentClick(fragment);
    }

    private boolean fragmentClick(Fragment fragment){

        if (fragment != null){

            getSupportFragmentManager().beginTransaction().replace(R.id.ganti, fragment).commit();

        }

        return false;

    }

}
