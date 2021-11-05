package com.example.desawisaratempellmahbang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class purchase_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_detail);

        Intent intent = getIntent();
        String purchaseAmount = intent.getStringExtra("purchaseAmount");
        TextView purchaseAmountTv = findViewById(R.id.totalpayment);
        purchaseAmountTv.setText(purchaseAmount);
    }
}