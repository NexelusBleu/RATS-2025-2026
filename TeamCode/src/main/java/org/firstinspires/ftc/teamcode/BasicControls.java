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

        double pad1LY = -gamepad1.left_stick_y;
        double pad1LX = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;

        double r = Math.sqrt(Math.pow(pad1LX,2) + Math.pow(pad1LY,2));
        double angle = Math.atan2(pad1LY,pad1LX);
        //Turning inputs into polar form

        double BLFR = (Math.sin(angle - (double) 1 /4*pi)*r) + turn;
        double  BRFL = (Math.sin(angle + (double) 1 /4*pi)*r) + turn;
        if(BLFR<-1 || BLFR>1 || BRFL<-1 || BRFL>1) {
            if(BLFR<-1 || BLFR>1){
                robot.frontLeft.setPower(-BRFL/Math.abs(BLFR));
                robot.backRight.setPower(BRFL/Math.abs(BLFR));
                robot.frontRight.setPower(BLFR/Math.abs(BLFR));
                robot.backLeft.setPower(-BLFR/Math.abs(BLFR));
            } else {
                robot.frontLeft.setPower(-BRFL/Math.abs(BRFL));
                robot.backRight.setPower(BRFL/Math.abs(BRFL));
                robot.frontRight.setPower(BLFR/Math.abs(BRFL));
                robot.backLeft.setPower(-BLFR/Math.abs(BRFL));
            }


        }else{
            robot.frontLeft.setPower(-BRFL);
            robot.backRight.setPower(BRFL);
            robot.frontRight.setPower(BLFR);
            robot.backLeft.setPower(-BLFR);
        }
    }
}
