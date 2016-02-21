package com.kennycason.gdx.controller.mapping;

/**
 * Created by kenny on 1/5/16.
 */
public class Axis {
    public final int id;
    // threshold is added as a convenience for checking whether or not an joystick
    // is being pushed in a particular direction.
    public final float threshold;

    /**
     * default to minimum sensitivity for "isPressed" functions
     * typically this constructor is used when you don't plan on using the joystick as a discrete d-pad
     * in practice the joysticks tend to register 0.00xyz when not pressed, so a low threshold can still be useful.
     */
    public Axis(final int id) {
        this(id, 0f);
    }

    public Axis(final int id, final float threshold) {
        this.id = id;
        this.threshold = threshold;
    }

}
