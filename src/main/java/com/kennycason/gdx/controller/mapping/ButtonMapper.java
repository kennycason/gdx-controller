package com.kennycason.gdx.controller.mapping;

import com.badlogic.gdx.utils.ObjectMap;
import com.kennycason.gdx.controller.controls.Controls;

/**
 * Created by kenny on 5/27/15.
 *
 * Button mappers are meant to abstract the underlying key codes (which are hard to memorize
 * and keep track of to easy to remember enums.
 */
public class ButtonMapper<V extends Controls> {

    private final ObjectMap<V, Integer> mapping = new ObjectMap<>();

    public ButtonMapper() {}

    public void map(V control, Integer mapping) {
        this.mapping.put(control, mapping);
    }

    public final Integer get(V control) {
        return mapping.get(control, -1);
    }

}
