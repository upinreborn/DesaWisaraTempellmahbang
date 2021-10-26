package com.example.desawisaratempellmahbang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mNameText;
        private TextView mPriceText;
        private ImageView mToursImage;
        ViewHolder(View itemView) {
            super(itemView);
            mNameText = (TextView)itemView.findViewById(R.id.name);
            mPriceText = (TextView)itemView.findViewById(R.id.price);
            mToursImage = itemView.findViewById(R.id.tourImage);
            itemView.setOnClickListener(this);
        }
        void bindTo(Tour currentTour){
            mNameText.setText(currentTour.getName());
            mPriceText.setText(String.valueOf(currentTour.getPrice()));
            Glide.with(mContext).load(currentTour.getImageResource()).into(mToursImage);
        }
        @Override
        public void onClick(View view) {
            Tour currentTour = mToursData.get(getAdapterPosition());
            price += currentTour.getPrice();
            mTotalPriceText.get().setText("TOTAL = " + String.valueOf(price));
        }
    }
}