GDX Controller
==============

The goal of GDX Controller is to make the using of controllers even easier in LibGDX.

## Features

1. A native interface for simultaneously handling both keyboard and controller input, called a MultiplexedController.
2. A button mapper to easily allow for custom mappings. Button and Axis.
3. Record time when buttons are pressed to allow for easier support for capturing button combinations.

## TODO

1. Better investigate Controller types
2. Add default mappings for various controllers. I.e. LogitechController and/or XBoxController will have a pre-configured Controls mapping.
3. Input combination checking to include timing between keypresses. i.e. ↓ ↘ → A
## Maven

```xml
<dependency>
    <groupId>com.kennycason</groupId>
    <artifactId>gdx-controller</artifactId>
    <version>1.0</version>
</dependency>
```

## Example

A simple PS1/PS2/Xbox like controller mapping.

```java
public enum MyGameControls implements Controls {
    DPAD_UP,
    DPAD_DOWN,
    DPAD_LEFT,
    DPAD_RIGHT,

    START,
    SELECT,

    A,
    B,
    X,
    Y,

    L1,
    L2,
    R1,
    R2
}
```

An example factory for building a keyboard, a Logitech controller, and a multiplexed controller.

```java
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

        // left joystick pressed 10
        // right joystick pressed 11

        buttonMapper.map(MyGameControls.L1, 4);
        buttonMapper.map(MyGameControls.L2, 6);
        buttonMapper.map(MyGameControls.R1, 5);
        buttonMapper.map(MyGameControls.R2, 7);

        final AxisMapper<MyGameControls> axisMapper = new AxisMapper<>();
        axisMapper.map(MyGameControls.DPAD_UP, new Axis(1, -0.75f));
        axisMapper.map(MyGameControls.DPAD_DOWN, new Axis(1, 0.75f));
        axisMapper.map(MyGameControls.DPAD_LEFT, new Axis(0, -0.75f));
        axisMapper.map(MyGameControls.DPAD_RIGHT, new Axis(0, 0.75f));

        return new LogitechController<>(0, buttonMapper, axisMapper);
    }

}
```

Bring it all together

```java
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
    }
    
}
```