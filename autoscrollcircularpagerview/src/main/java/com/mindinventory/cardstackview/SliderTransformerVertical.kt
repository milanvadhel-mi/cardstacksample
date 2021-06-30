package com.mindinventory.cardstackview

import android.util.Log
import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs


class SliderTransformerVertical(private val offscreenPageLimit: Int) : ViewPager2.PageTransformer {

    companion object {

        // Scale Height
        private const val DEFAULT_TRANSLATION_Y = .0f

        // To Show the card behind first card
        private const val DEFAULT_TRANSLATION_FACTOR = 1.10f

        // Manage the Height of Hidden cards behind first card
        private const val SCALE_FACTOR = .15f // Large device
        private const val DEFAULT_SCALE = 1f

        private const val ALPHA_FACTOR = .0f
        private const val DEFAULT_ALPHA = 1f

        private val TAG = "SliderTransformerVertical"

    }

    override fun transformPage(page: View, position: Float) {

        page.apply {

            ViewCompat.setElevation(page, -abs(position))

            val scaleFactor = -SCALE_FACTOR * position + DEFAULT_SCALE
            val alphaFactor = -ALPHA_FACTOR * position + DEFAULT_ALPHA
            Log.d(TAG, "ScaleFactor : $scaleFactor")
            Log.d(TAG, "AlphaFactor : $alphaFactor")

            when {
                position <= 0f -> {
                    translationY = DEFAULT_TRANSLATION_Y
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                    alpha = DEFAULT_ALPHA + position
                }
                position <= offscreenPageLimit - 1 -> {
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                    translationY = -(height/DEFAULT_TRANSLATION_FACTOR) * position
                    Log.d(TAG, "Width : $width  TranslationY : $translationY  Position : $position")
                    alpha = alphaFactor
                }
                else -> {
                    translationY = DEFAULT_TRANSLATION_Y
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                    alpha = DEFAULT_ALPHA
                }
            }
        }
    }
}