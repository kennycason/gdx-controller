package com.kennycason.gdx.controller.implementation;

import com.badlogic.gdx.Input;
import com.kennycason.gdx.controller.KeyboardController;
import com.kennycason.gdx.controller.LogitechController;
import com.kennycason.gdx.controller.MultiplexedController;
import com.kennycason.gdx.controller.mapping.Axis;
import com.kennycason.gdx.controller.mapping.AxisMapper;
import com.kennycason.gdx.controller.mapping.ButtonMapper;

/**
 * Created by kenny on 1/5/16.
 *
 * An example factory for building a keyboard, a Logitech controller, and a multiplexed controller.
 */
public class MyControllerFactory {

    public static MultiplexedController<MyGameControls> buildMultiController() {
        return new MultiplexedController<>(buildKeyboard(), buildLogitech());
    }

    public static KeyboardController<MyGameControls> buildKeyboard() {
        final ButtonMapper<MyGameControls> buttonMapper = new ButtonMapper<>();
        buttonMapper.map(MyGameControls.DPAD_UP, Input.Keys.UP);
        buttonMapper.map(MyGameControls.DPAD_DOWN, Input.Keys.DOWN);
        buttonMapper.map(MyGameControls.DPAD_LEFT, Input.Keys.LEFT);
        buttonMapper.map(MyGameControls.DPAD_RIGHT, Input.Keys.RIGHT);

        buttonMapper.map(MyGameControls.START, Input.Keys.ENTER);
        buttonMapper.map(MyGameControls.SELECT, Input.Keys.SHIFT_RIGHT);

        buttonMapper.map(MyGameControls.A, Input.Keys.Z);
        buttonMapper.map(MyGameControls.B, Input.Keys.X);
        buttonMapper.map(MyGameControls.X, Input.Keys.A);
        buttonMapper.map(MyGameControls.Y, Input.Keys.S);

        buttonMapper.map(MyGameControls.L1, Input.Keys.Q);
        buttonMapper.map(MyGameControls.L2, Input.Keys.W);
        buttonMapper.map(MyGameControls.R1, Input.Keys.C);
        buttonMapper.map(MyGameControls.R2, Input.Keys.D);

        return new KeyboardController<>(buttonMapper);
    }

    public static LogitechController<MyGameControls> buildLogitech() {
        final ButtonMapper<MyGameControls> buttonMapper = new ButtonMapper<>();
        // dpad buttons are read from axis's, not button codes directly
        // consider allowing axis's to be configured.

        buttonMapper.map(MyGameControls.START, 9);
        buttonMapper.map(MyGameControls.SELECT, 8);

        buttonMapper.map(MyGameControls.A, 1);
        buttonMapper.map(MyGameControls.B, 2);
        buttonMapper.map(MyGameControls.X, 0);
        buttonMapper.map(MyGameControls.Y, 3);

        buttonMapper.map(MyGameControls.L1, 4);
        buttonMapper.map(MyGameControls.L2, 6);
        buttonMapper.map(MyGameControls.R1, 5);
        buttonMapper.map(MyGameControls.R2, 7);

        // treating the axis / joystick as a typical d-pad
        final AxisMapper<MyGameControls> axisMapper = new AxisMapper<>();
        axisMapper.map(MyGameControls.DPAD_UP, new Axis(1, -0.75f));
        axisMapper.map(MyGameControls.DPAD_DOWN, new Axis(1, 0.75f));
        axisMapper.map(MyGameControls.DPAD_LEFT, new Axis(0, -0.75f));
        axisMapper.map(MyGameControls.DPAD_RIGHT, new Axis(0, 0.75f));

        // hook in joystick for raw usage, i.e you need precise control over the joystick's position.
        axisMapper.map(MyGameControls.RIGHT_JOYSTICK_VERTICAL, new Axis(3));
        axisMapper.map(MyGameControls.RIGHT_JOYSTICK_HORIZONTAL, new Axis(2));

        return new LogitechController<>(0, buttonMapper, axisMapper);
    }

}
