package com.cuncaojin.cloudplay.util

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.ImageView

import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.bumptech.glide.request.transition.Transition
import com.cuncaojin.cloudplay.R

import jp.wasabeef.blurry.Blurry

/**
 * @author geyifeng
 * @date 2019-04-20 02:00
 */
object GlideUtils {
    fun load(obj: Any, imageView: ImageView?) {
        if (imageView == null) {
            return
        }
        load(obj, imageView, R.drawable.default_image)
    }

    @Suppress("NAME_SHADOWING")
    fun load(`object`: Any?, imageView: ImageView?, @DrawableRes placeholder: Int) {
        var `object` = `object`
        if (imageView == null) {
            return
        }
        if (!NetStatusUtil.isNetworkConnected(imageView.context)) {
            `object` = ContextCompat.getDrawable(imageView.context, placeholder)
        }
        Glide.with(imageView).load(`object`).apply(RequestOptions().placeholder(placeholder)).into(imageView)
    }

    fun loadBlurry(imageView: ImageView?, o: Any?) {
        var o = o
        if (imageView == null) {
            return
        }
        var drawable: Drawable? = imageView.drawable
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(imageView.context, R.drawable.default_image)
        }
        if (!NetStatusUtil.isNetworkConnected(imageView.context)) {
            o = ContextCompat.getDrawable(imageView.context, R.drawable.default_image)
        }
        Glide.with(imageView.context).load(o).apply(RequestOptions().placeholder(drawable).error(drawable).centerCrop()).transition(DrawableTransitionOptions().crossFade()).into<DrawableImageViewTarget>(object : DrawableImageViewTarget(imageView) {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                val bitmap = (resource as BitmapDrawable).bitmap
                Blurry.with(imageView.context).from(bitmap).into(imageView)
            }
        })
    }
}
