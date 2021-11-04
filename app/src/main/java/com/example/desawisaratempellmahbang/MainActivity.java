package com.example.desawisaratempellmahbang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TourAdapter mAdapter;
    private ArrayList<Tour> mSportsData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
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
        for (int i = 0; i < toursName.length; i++) {
            mSportsData.add(new Tour(toursName[i], Integer.parseInt(toursPrice[i]), tourImagesResources.getResourceId(i, 0)));
        }
        tourImagesResources.recycle();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void Location(MenuItem item) {
        Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=Rumah+Alfin,+Jl.+Sadeng+II,+Sadeng,+Kec.+Gn.+Pati,+Kota+Semarang,+Jawa+Tengah+50222");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void callCenter(MenuItem item) {
        String dial = "tel:" + "+6289683629107";
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
    }


    public void smsCenter(MenuItem item) {
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + "+6289683629107"));
        smsIntent.putExtra("sms_body", "Halo admin, saya perlu bantuan");
        startActivity(smsIntent);
    }

    public void setting(MenuItem item) {
        Intent update = new Intent(this, update_user.class);
        startActivity(update);
    }


    public void logout(MenuItem item) {
        Intent update = new Intent(this, loginUser.class);
        startActivity(update);
        finish();
    }
}