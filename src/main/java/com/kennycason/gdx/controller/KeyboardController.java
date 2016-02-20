package com.kennycason.gdx.controller;

import com.badlogic.gdx.Gdx;
import com.kennycason.gdx.controller.controls.Controls;
import com.kennycason.gdx.controller.mapping.ButtonMapper;

/**
 * Created by kenny on 5/22/15.
 *
 * A very basic keyboard controller implementation.
 */
public class KeyboardController<V extends Controls> extends Controller<V> {

    public KeyboardController(final ButtonMapper<V> buttonMapper) {
        super.buttonMapper = buttonMapper;
    }

    @Override
    public boolean isPressed(V control) {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(control));
        if (pressed) { record(control); }
        return pressed;
    }

    @Override
    public float getAxis(V control) {
        return 0f;
    }

}
