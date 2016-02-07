package com.teamvoy.cam.food2fork.recycler;

import android.graphics.Bitmap;
import android.view.View;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardItem {

    private String contentTitle;
    private String contentAuthor;
    private String imageUrl;
    private String rId;
    private Bitmap imageBitmap;
    private String btnCaption;
    private String rating;
    private View.OnClickListener btnOnClickListener;

    public CardItem(String contentTitle, String contentAuthor, String imageUrl, String rId, String rating) {
        this.contentAuthor = contentAuthor;
        this.contentTitle = contentTitle;
        this.imageUrl = imageUrl;
        this.rId = rId;
        this.rating = rating;
    }
}
