package org.firstinspires.ftc.teamcode;

public class utiliCode {

    private utiliCode() {

        throw new UnsupportedOperationException("Utility class");

    }
    public static double rampPower(double current, double target, double step) {
        if (current < target){
            current += step;
        
            if (current > target) current = target;
        
        } else if (current > target) {
            current -= step;

            if (current < target) current = target;
        }
        return current;
    }

    public static double deadZone(double input, double r){

        if (Math.abs(input) < r) input = 0;

        return input;
    }
}
