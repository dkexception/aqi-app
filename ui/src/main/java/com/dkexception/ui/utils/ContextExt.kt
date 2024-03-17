package com.dkexception.ui.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.Dp
import androidx.core.content.ContextCompat
import androidx.core.util.TypedValueCompat

fun Context.getImageBitmapFromVector(
    @DrawableRes vectorDrawableRes: Int
): ImageBitmap {

    val drawable = ContextCompat.getDrawable(this, vectorDrawableRes)!!

    val bitmap = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)

    return bitmap.asImageBitmap()
}

fun Context.pxToDp(px: Int): Dp =
    Dp(TypedValueCompat.pxToDp(px.toFloat(), resources.displayMetrics))
