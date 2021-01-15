package com.hr170011.fatih_arslan_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }
}
