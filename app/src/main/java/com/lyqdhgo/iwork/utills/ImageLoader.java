package com.lyqdhgo.iwork.utills;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by QiDeHong on 2017/5/21.
 * Function:load imageView
 */

public class ImageLoader {
    public static void load(Context context, Uri uri, ImageView imageView) {
        Glide.with(context)
                .load(uri)
                .into(imageView);
    }
}
