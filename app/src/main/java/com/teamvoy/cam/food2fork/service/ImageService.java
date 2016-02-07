package com.teamvoy.cam.food2fork.service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ImageService extends AsyncTask<View, Void, Bitmap> {

    private String url;

    public ImageService(String url) {
        this.url = url;
    }

    @Override
    protected Bitmap doInBackground(View... imageViews) {
        Bitmap image;
        try {
            image = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
            return image;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
