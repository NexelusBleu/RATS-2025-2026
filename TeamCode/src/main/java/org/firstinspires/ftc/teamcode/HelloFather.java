package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class HelloFather extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Hello", "Mr.", "Name");
    }

    @Override
    public void loop() {
        
    }
}
