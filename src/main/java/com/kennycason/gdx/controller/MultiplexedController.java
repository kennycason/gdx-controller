package com.kennycason.gdx.controller;

import com.kennycason.gdx.controller.controls.Controls;

/**
 * Created by kenny on 1/5/16.
 *
 * A multiplexed controller is designed to handle when games support both multiple functional input
 * methods by easily bundling them into one class.
 *
 * For example, a game that supports both keyboard and controller input. This class
 * allows you to only have to check this single class for input.
 */
public class MultiplexedController<V extends Controls> extends Controller<V> {

    private final Controller[] controllers;

    public MultiplexedController(final Controller... controllers) {
        this.controllers = controllers;
    }

    @Override
    public boolean isPressed(final V control) {
        for (final Controller controller : controllers) {
            if (controller.isPressed(control)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public float getAxis(final  V control) {
        for (final Controller controller : controllers) {
            final float axis = controller.getAxis(control);
            if (axis != 0.0f) {
                return axis;
            }
        }
        return 0.0f;
    }

    @Override
    public long when(final V control) {
        for (final Controller controller : controllers) {
            final long when = controller.when(control);
            if (when > 0) {
                return when;
            }
        }
        return 0L;
    }

}