package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class BasicControls extends OpMode {

    HardwareClass robot = new HardwareClass();

    double pi = Math.PI;
    @Override
    public void init() {
        robot.init(hardwareMap);

    }

    @Override
    public void loop() {

        double pad1LY = -gamepad1.left_stick_y/4;
        double pad1LX = gamepad1.left_stick_x/4;
        double turn = -gamepad1.right_stick_x/2;

        double r = Math.sqrt(Math.pow(pad1LX,2) + Math.pow(pad1LY,2));
        double angle = Math.atan2(pad1LY,pad1LX);
        //Turning inputs into polar form

        double BLFR = (Math.sin(angle - (double) 1/4*pi)*r);
        double  BRFL = (Math.sin(angle + (double) 1/4*pi)*r);
        if(BLFR<-1 || BLFR>1 || BRFL<-1 || BRFL>1) {
            if(BLFR<-1 || BLFR>1){
                robot.frontLeft.setPower(-BRFL/Math.abs(BLFR+turn));
                robot.backRight.setPower(BRFL/Math.abs(BLFR+turn));
                robot.frontRight.setPower(BLFR/Math.abs(BLFR+turn));
                robot.backLeft.setPower(-BLFR/Math.abs(BLFR+turn));
            } else {
                robot.frontLeft.setPower(-BRFL/Math.abs(BRFL+turn));
                robot.backRight.setPower(BRFL/Math.abs(BRFL+turn));
                robot.frontRight.setPower(BLFR/Math.abs(BRFL+turn));
                robot.backLeft.setPower(-BLFR/Math.abs(BRFL+turn ));
            }


        }else{
            robot.frontLeft.setPower(-BRFL+turn);
            robot.backRight.setPower(BRFL+turn);
            robot.frontRight.setPower(BLFR+turn);
            robot.backLeft.setPower(-BLFR+turn);
        }
    }
}
