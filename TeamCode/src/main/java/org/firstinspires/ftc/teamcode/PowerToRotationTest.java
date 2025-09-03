package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class PowerToRotationTest extends OpMode {

    HardwareClass robot = new HardwareClass();

    private ElapsedTime timer = new ElapsedTime();
    private double LastLogTime = 0;
    @Override
    public void init() {

        robot.init(hardwareMap);

    }


    @Override
    public void loop() {

        double currentTime = timer.seconds();
        


    }
}
