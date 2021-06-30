package com.mindinventory.cardstackview;

import android.view.animation.Interpolator;

public interface AnimationSetting {
    Direction getDirection();
    int getDuration();
    Interpolator getInterpolator();
}
