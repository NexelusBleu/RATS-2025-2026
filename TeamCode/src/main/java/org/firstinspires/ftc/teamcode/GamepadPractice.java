package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp
public class GamepadPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double speedForward = -gamepad1.left_stick_y / 2.0;

        telemetry.addData("x value", gamepad1.left_stick_x);
        //reads values from left stick and prints
        telemetry.addData("y", speedForward);
        telemetry.addData("a button", gamepad1.a);
        //reads if a is being pressed
    }
}
