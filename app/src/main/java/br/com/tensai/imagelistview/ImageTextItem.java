package br.com.tensai.imagelistview;

import android.graphics.drawable.Drawable;

/**
 * Created by jader on 31/03/15.
 */
public class ImageTextItem {

    String title;
    String detail;
    Drawable image;

    public ImageTextItem(String title, String detail, Drawable image) {
        this.title = title;
        this.detail = detail;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public Drawable getImage() {
        return image;
    }
}
