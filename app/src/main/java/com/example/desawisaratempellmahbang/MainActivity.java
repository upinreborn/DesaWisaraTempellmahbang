package com.example.desawisaratempellmahbang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TourAdapter mAdapter;
    private ArrayList<Tour> mSportsData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mSportsData = new ArrayList<>();
        mAdapter = new TourAdapter(this, mSportsData, findViewById(R.id.totalPrice));
        mRecyclerView.setAdapter(mAdapter);
        initializeData();
    }

    private void initializeData() {
        String[] toursName = getResources().getStringArray(R.array.tour_packages);
        String[] toursPrice = getResources().getStringArray(R.array.tours_price);
        TypedArray tourImagesResources =
                getResources().obtainTypedArray(R.array.tour_images);
        mSportsData.clear();
        for(int i=0;i<toursName.length;i++){
            mSportsData.add(new Tour(toursName[i], Integer.parseInt(toursPrice[i]), tourImagesResources.getResourceId(i, 0)));
        }
        tourImagesResources.recycle();
        mAdapter.notifyDataSetChanged();
    }
}