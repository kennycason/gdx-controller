package com.kennycason.gdx.controller.mapping;

import com.badlogic.gdx.utils.ObjectMap;

/**
 * Created by kenny on 1/5/16.
 */
public class AxisMapper<V> {

    protected final ObjectMap<V, Axis> mapping = new ObjectMap<>();

    public AxisMapper() {}

    public void map(V control, Axis mapping) {
        this.mapping.put(control, mapping);
    }

    public Axis get(V control) {
        return mapping.get(control, null);
    }

}