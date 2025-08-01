package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class BasicControls extends OpMode {

    private DcMotor frontLeft = null;
    private DcMotor backLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backRight = null;
    double pi = Math.PI;
    @Override
    public void init() {
    frontLeft = hardwareMap.get(DcMotor.class,"frontLeft");
    backLeft = hardwareMap.get(DcMotor.class, "backLeft");
    frontRight = hardwareMap.get(DcMotor.class, "frontRight");
    backRight = hardwareMap.get(DcMotor.class,"backRight");
    }

    @Override
    public void loop() {
        double pad1LY = -gamepad1.left_stick_y;
        double pad1LX = gamepad1.left_stick_x;

        double r = Math.sqrt(Math.pow(pad1LX,2) + Math.pow(pad1LY,2));
        double angle = Math.atan2(pad1LY,pad1LX);
        //Turning inputs into polar form

        double BLFR = Math.sin(angle - (double) 1 /4*pi)*r;
        double BLFR = Math.sin(angle - (double) 1 /4*pi)*r;
        double  BRFL = Math.sin(angle + (double) 1 /4*pi)*r;
        frontLeft.setPower(BRFL);
        backRight.setPower(BRFL);
        frontRight.setPower(BLFR);
        backLeft.setPower(BLFR);

    }
}
