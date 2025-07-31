package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class VariablePractice extends OpMode {

    @Override
    public void init() {
        int teamNumber = 22448;
        //int are only rounded numbers and not decimals
        double motorSpeed = 0.75;
        //double are decimals
        boolean clawClosed = true;
        //boolean are true or false
        String teamName = "The Rats";
        //String are words

        telemetry.addData("team number", teamNumber );
        telemetry.addData("motor speed", motorSpeed);
        telemetry.addData("claw closed", clawClosed);
        telemetry.addData("team name", teamName);
    }

    public void loop(){

    }
}
