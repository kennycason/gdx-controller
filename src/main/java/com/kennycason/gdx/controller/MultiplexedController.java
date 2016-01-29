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

    public boolean isPressed(final V control) {
        for (Controller controller : controllers) {
            if (controller.isPressed(control)) {
                return true;
            }
        }
        return false;
    }

    public long whenPressed(final V control) {
        for (Controller controller : controllers) {
            final long when = controller.when(control);
            if (when > 0) {
                return when;
            }
        }
        return 0L;
    }

}