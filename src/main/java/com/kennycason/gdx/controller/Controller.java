package com.kennycason.gdx.controller;

import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.TimeUtils;
import com.kennycason.gdx.controller.controls.Controls;
import com.kennycason.gdx.controller.mapping.AxisMapper;
import com.kennycason.gdx.controller.mapping.ButtonMapper;

/**
 * Created by kenny on 5/22/15.
 *
 * Simple controller interface
 */
public abstract class Controller<V extends Controls> {

    private ObjectMap<V, Long> lastPressed = new ObjectMap<>();

    protected ButtonMapper<V> buttonMapper;

    protected AxisMapper<V> axisMapper;

    public abstract boolean isPressed(V control);

    public abstract float getAxis(V control);

    public long when(V control) {
        return lastPressed.get(control, 0L);
    }

    public void record(V control) {
        lastPressed.put(control, TimeUtils.millis());
    }

}