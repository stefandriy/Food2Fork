package com.teamvoy.cam.food2fork.recycler;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamvoy.cam.food2fork.R;
import com.teamvoy.cam.food2fork.service.ImageService;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.DataObjectHolder> {
    private ArrayList<CardItem> dataSet;

    public CardRecyclerAdapter(ArrayList<CardItem> dataSet) {
        this.dataSet = new ArrayList<>(dataSet);
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);

        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        CardItem data = dataSet.get(position);

        // title
        if (data.getContentTitle() == null) {
            holder.titleTV.setVisibility(View.GONE);
        } else {
            holder.titleTV.setVisibility(View.VISIBLE);
            holder.titleTV.setText(data.getContentTitle());
        }

        // content text
        if (data.getContentAuthor() == null) {
            holder.authorTV.setVisibility(View.GONE);
        } else {
            holder.authorTV.setVisibility(View.VISIBLE);
            holder.authorTV.setText(data.getContentAuthor());
        }

        // content rating
        if (data.getRating() == null) {
            holder.ratingTV.setVisibility(View.GONE);
        } else {
            holder.ratingTV.setVisibility(View.VISIBLE);
            holder.ratingTV.setText(data.getRating());
        }

        // button
        if (data.getBtnOnClickListener() == null) {
            holder.actionButton.setVisibility(View.GONE);
        } else {
            holder.actionButton.setVisibility(View.VISIBLE);
            holder.actionButton.setOnClickListener(data.getBtnOnClickListener());
            holder.actionButton.setText(data.getBtnCaption());
        }

        // image
        if (data.getImageUrl() == null) {
            holder.imageIV.setVisibility(View.GONE);
        } else {
            holder.imageIV.setVisibility(View.VISIBLE);

            holder.imageIV.setImageBitmap(null);

            if (data.getImageBitmap() == null) {
                // load image from URL
                new ReceiveImage(data, position).execute();
            } else {
                holder.imageIV.setImageBitmap(data.getImageBitmap());
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView titleTV;
        TextView authorTV;
        Button actionButton;
        ImageView imageIV;
        TextView ratingTV;

        public DataObjectHolder(View itemView) {
            super(itemView);
            titleTV = (TextView) itemView.findViewById(R.id.card_titleTV);
            authorTV = (TextView) itemView.findViewById(R.id.card_authorTV);
            actionButton = (Button) itemView.findViewById(R.id.card_button);
            imageIV = (ImageView) itemView.findViewById(R.id.card_imageIV);
            ratingTV = (TextView) itemView.findViewById(R.id.card_ratingTV);
        }
    }


    public class ReceiveImage extends ImageService {

        private CardItem cardItem;
        private int position;

        public ReceiveImage(CardItem cardItem, int position) {
            super(cardItem.getImageUrl());
            this.cardItem = cardItem;
            this.position = position;
        }

        @Override
        protected Bitmap doInBackground(View... imageViews) {
            Bitmap bitmap;

            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(cardItem.getImageUrl()).getContent());
                return bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                cardItem.setImageBitmap(result);
                notifyItemChanged(position);
            }
        }
    }
}