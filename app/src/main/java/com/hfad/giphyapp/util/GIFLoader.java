package com.hfad.giphyapp.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hfad.giphyapp.R;

/**
 * Created by sarahzhou on 8/21/17.
 */
public class GIFLoader {

    public static void loadGIF(String gif, ImageView view, Context context) {
        if (!TextUtils.isEmpty(gif)) {
            Glide.with(context)
                    .load(gif)
                    .asGif()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.drawable.placeholder)
                    .into(view);
        }
    }

}
