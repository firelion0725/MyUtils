package com.leo.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;

/**
 * @author leo, ZhangWei
 * @date 2018/7/10
 */
public class ImageUtils {

    public static Bitmap drawableToBitmap(Drawable drawable) {
        return drawableToBitmap(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    public static Bitmap drawableToBitmap(Drawable drawable, int width, int height) {
        if (drawable instanceof BitmapDrawable) {
            return ThumbnailUtils.extractThumbnail(((BitmapDrawable) drawable).getBitmap(), width, height);
        } else {
            return drawableToBitmapWithCanvas(drawable, width, height);
        }
    }

    public static Bitmap drawableToBitmapWithCanvas(Drawable drawable, int width, int height) {
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(width, height, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    public static Drawable bitmapToDrawable(Bitmap bitmap, Resources res) {
        return new BitmapDrawable(res, bitmap);
    }
}
