package com.kennycason.gdx.controller.implementation;

import com.kennycason.gdx.controller.Controller;

/**
 * Created by kenny on 1/29/16.
 *
 * A sample handle input loop example.
 */
public class MyGameSreen {

    private final Controller<MyGameControls> controller = MyControllerFactory.buildMultiController();

    private void handleInput(final float deltaTime) {
        // note that the left joystick is also mapped to the DPAD movement for
        // seamless joystick/dpad controls
        if (controller.isPressed(MyGameControls.DPAD_LEFT)) {
            // move left
        }
        if (controller.isPressed(MyGameControls.DPAD_RIGHT)) {
            // move right
        }
        if (controller.isPressed(MyGameControls.DPAD_UP)) {
            // move up
        }
        if (controller.isPressed(MyGameControls.DPAD_DOWN)) {
            // move down
        }
        if (controller.isPressed(MyGameControls.L1)) {
            // scroll weapon down
        }
        if (controller.isPressed(MyGameControls.R1)) {
            // scroll weapon up
        }
        if (controller.isPressed(MyGameControls.START)) {
            // pause
        }
        if (controller.isPressed(MyGameControls.A)) {
            // shoot!
        }
        final float joystickVertical = controller.getAxis(MyGameControls.RIGHT_JOYSTICK_VERTICAL);
        final float joystickHorizontal = controller.getAxis(MyGameControls.RIGHT_JOYSTICK_HORIZONTAL);
        // do something with the vertical and horizontal values. perhaps take the unit vector and use
        // as a more precise facing vector
    }

}
