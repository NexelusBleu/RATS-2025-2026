package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class BasicControls extends OpMode {

    //this allows for pulling from the Hardware class
    HardwareClass robot = new HardwareClass();

    //these can be edited to change the feel of the robot
    double rampSpeed = .03;
    double deadZoneR = .15;
    double turnStrength = 0.5;
    double strafeStrength = 1.2;
    double flPower, frPower, blPower, brPower;

    @Override
    public void init() {

        //initializes all the motor and position on brain
        robot.init(hardwareMap);

    }

    @Override
    public void loop() {

        //finds the angle of the robot
        double robotAngle = robot.getHeading();
        telemetry.addData("degree", robotAngle);
        telemetry.update();

        //initializing game pads and adding dead-zones to make less is less sensitive
        double pad1LY = -utiliCode.deadZone(gamepad1.left_stick_y,deadZoneR);
        double pad1LX = utiliCode.deadZone(gamepad1.left_stick_x, deadZoneR)*strafeStrength;
        double turn = -utiliCode.deadZone(gamepad1.right_stick_x, deadZoneR)*turnStrength;

        //This calculate all the powers for the mecanum wheels
        double flTarget = pad1LY + pad1LX - turn;
        double frTarget = pad1LY - pad1LX + turn;
        double blTarget = pad1LY - pad1LX - turn;
        double brTarget = pad1LY + pad1LX + turn;

        //normalizes all inputs
        double max = Math.max(1.0, Math.max(Math.abs(flTarget), Math.max(Math.abs(blTarget),
                Math.max(Math.abs(frTarget), Math.abs(brTarget)))));

        flPower /= max;
        frPower /= max;
        blPower /= max;
        brPower /= max;

        // Ramps up the power to make the controllers more natural and smooth
        flPower = utiliCode.rampPower(flPower, flTarget, rampSpeed);
        frPower = utiliCode.rampPower(frPower, frTarget, rampSpeed);
        blPower = utiliCode.rampPower(blPower, blTarget,  rampSpeed);
        brPower = utiliCode.rampPower(brPower, brTarget, rampSpeed);

        //Set all of the motor
        robot.frontLeft.setPower(flPower);
        robot.frontRight.setPower(frPower);
        robot.backRight.setPower(brPower);
        robot.backLeft.setPower(blPower);
    }
}
