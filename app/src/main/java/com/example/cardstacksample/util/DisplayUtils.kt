package com.example.cardstacksample.util

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue

object DisplayUtils {

    fun dpToPx(dp: Float, context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.resources.displayMetrics
        ).toInt()
    }

    fun getDisplayHeight(context: Context): Int {
        val displayMetrics = DisplayMetrics()
        context.display?.getRealMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    fun getDisplayWidth(context: Context): Int {
        val displayMetrics = DisplayMetrics()
        context.display?.getRealMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }
}