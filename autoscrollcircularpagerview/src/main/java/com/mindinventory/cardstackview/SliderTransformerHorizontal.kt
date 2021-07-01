package com.mindinventory.cardstackview

import android.util.Log
import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs


class SliderTransformerHorizontal(private val offscreenPageLimit: Int) :
    ViewPager2.PageTransformer {

    companion object {

        private const val DEFAULT_ELEVATION = 2f

        private const val DEFAULT_TRANSLATION_X = .0f
        private const val DEFAULT_TRANSLATION_Y = .0f

        // As Per Increase , Card will go up side on Y Axis
        // As per Decrease , Card will go down side on Y Axis
        private const val DEFAULT_TRANSLATION_FACTOR_Y = 6.2f

        private const val DEFAULT_TRANSLATION_FACTOR_X = 1f

        private const val SCALE_FACTOR = .14f
        private const val DEFAULT_SCALE = 1f

        private const val ALPHA_FACTOR = .0f
        private const val DEFAULT_ALPHA = 1f

        private val TAG = "SliderTransformerHorizontal"
    }

    override fun transformPage(page: View, position: Float) {
        //Log.d(TAG, "Current Page Position : $position")
        page.apply {

            ViewCompat.setElevation(page, -abs(position))

            val scaleFactor = -SCALE_FACTOR * position + DEFAULT_SCALE
            val alphaFactor = -ALPHA_FACTOR * position + DEFAULT_ALPHA

            when {
                position <= 0f -> {
                    translationX = DEFAULT_TRANSLATION_X
                    translationY = DEFAULT_TRANSLATION_Y
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                    alpha = DEFAULT_ALPHA + position
                    Log.d(TAG, "Position => $position  TranslationX -> $translationX  TranslationY -> $translationY ScaleX -> $scaleX  ScaleY -> $scaleY")
                }
                position <= offscreenPageLimit - 1 -> {
                    scaleX = scaleFactor
                    scaleY = scaleFactor

                    // To Move Page From it's position to up side(plus side) on Y-Axis
                    translationY = (width / DEFAULT_TRANSLATION_FACTOR_Y) * position

                    // To Move Page From it's position to left side(minus side) on X-Axis
                    translationX = -(width / DEFAULT_TRANSLATION_FACTOR_X) * position
                    alpha = alphaFactor

                    //Log.d(TAG, "Position => $position  TranslationX -> $translationX  TranslationY -> $translationY ScaleX -> $scaleX  ScaleY -> $scaleY")

                }
                else -> {
                    ViewCompat.setElevation(page, DEFAULT_ELEVATION/4)
                    translationX = DEFAULT_TRANSLATION_X
                    translationY = DEFAULT_TRANSLATION_Y
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                    alpha = DEFAULT_ALPHA

                    Log.d(TAG, "Position => $position  TranslationX -> $translationX  TranslationY -> $translationY ScaleX -> $scaleX  ScaleY -> $scaleY")
                }
            }
        }
    }
}