package com.example.desawisaratempellmahbang;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TourAdapter extends
        RecyclerView.Adapter<TourAdapter.ViewHolder> {
    int price = 0;
    private ArrayList<Tour> mToursData;
    private Context mContext;
    private WeakReference<TextView> mTotalPriceText;
    TourAdapter(Context context, ArrayList<Tour> toursData, TextView totalPriceText) {
        this.mToursData = toursData;
        this.mContext = context;
        this.mTotalPriceText = new WeakReference<>(totalPriceText);
    }

    @Override
    public TourAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new
                ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(TourAdapter.ViewHolder holder, int position) {
        Tour currentTour = mToursData.get(position);
        holder.bindTo(currentTour);
    }

    @Override
    public int getItemCount() {
        return mToursData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mNameText;
        private TextView mPriceText;
        private ImageView mTourImage;

        ViewHolder(View itemView) {
            super(itemView);
            mNameText = (TextView)itemView.findViewById(R.id.name);
            mPriceText = (TextView)itemView.findViewById(R.id.price);
            mTourImage = itemView.findViewById(R.id.tourImage);
            mTourImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Tour currentTour = mToursData.get(getAdapterPosition());
                    price += currentTour.getPrice();
                    mTotalPriceText.get().setText("TOTAL = " + String.valueOf(price));
                }
            });
            mNameText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Tour currentTour = mToursData.get(getAdapterPosition());
                    Intent intent = new Intent(mContext, product_detail.class);
                    intent.putExtra("productName", currentTour.getName());
                    intent.putExtra("productDescription", currentTour.getDescription());
                    intent.putExtra("productImage", currentTour.getImageResource());
                    mContext.startActivity(intent);
                }
            });
        }

        void bindTo(Tour currentTour){
            mNameText.setText(currentTour.getName());
            mPriceText.setText(String.valueOf(currentTour.getPrice()));
            Glide.with(mContext).load(currentTour.getImageResource()).into(mTourImage);
        }
    }
}