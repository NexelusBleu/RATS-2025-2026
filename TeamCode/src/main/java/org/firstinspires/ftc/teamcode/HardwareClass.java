package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class HardwareClass {
    public DcMotor frontLeft, frontRight, backLeft, backRight;

    public IMU imu;

    public void init(HardwareMap hwMap){

        //intialing motor locations
        frontLeft = hwMap.get(DcMotorEx.class, "frontLeft");

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        frontRight = hwMap.get(DcMotorEx.class, "frontRight");

        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backLeft = hwMap.get(DcMotorEx.class, "backLeft");

        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backRight = hwMap.get(DcMotorEx.class,"backRight");

        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);




        //Initalinzings other hardware

        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOriention = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.LEFT
        );

        imu.initialize(new IMU.Parameters(RevOriention));

    }

    public double getHeading(){

        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);

    }
}
