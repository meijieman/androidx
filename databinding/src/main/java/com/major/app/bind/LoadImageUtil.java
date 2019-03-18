package com.major.app.bind;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.major.app.GlideApp;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.app
 * ProjectName: dagger2
 * Date: 2019/3/18 11:40
 */
public class LoadImageUtil {

    @BindingAdapter({"img:imgurl", "img:placeholder", "img:error"})
    public static void loadImage(ImageView imageView, String url, Drawable holderDrawable, Drawable errorDrawable) {
        GlideApp.with(imageView.getContext())
                .load(Uri.parse(url))
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .fitCenter()
//                .transform(new GlideCircleTransform())
                .into(imageView);
    }
}
