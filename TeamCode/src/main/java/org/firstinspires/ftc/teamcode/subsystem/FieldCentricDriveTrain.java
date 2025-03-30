package org.firstinspires.ftc.teamcode.subsystem;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.utility.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.utility.telemetry.TelemetryObservable;

/**
 * Concrete class for a field-centric drive train
 * @see <a href="https://compendium.readthedocs.io/en/latest/_images/centric.png"> Robot Centric vs. Field Centric </a>
 */
public class FieldCentricDriveTrain extends DriveTrain implements TelemetryObservable {
    public FieldCentricDriveTrain(HardwareMap hw, Pose2d start) {
        super(hw, start);
    }

    /**
     * Drive Train implementation from this <a href="https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html#field-centric-final-sample-code">guide</a>
     * @param x Amount of x (Ex. left/right on the left joystick)
     * @param y Amount of y (Ex. up/down on the left joystick)
     * @param turn Amount of turn (Ex. left/right on the right joystick)
     */
    @Override
    public void drive(double x, double y, double turn) {
        double rotX = x * Math.cos(-getHeading()) - y * Math.sin(-getHeading());
        double rotY = x * Math.sin(-getHeading()) + y * Math.cos(-getHeading());
        rotX *= 1.1; // Counteract imperfect strafing

        double normalize = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(turn), 1);
        double leftPower = (rotY + rotX + turn) / normalize;
        double leftBackPower = (rotY - rotX + turn) / normalize;
        double rightPower = (rotY - rotX - turn) / normalize;
        double rightBackPower = (rotY + rotX - turn) / normalize;

        //ArraySelect<Double> speeds = getSpeeds();
        super.setDrivePowers(
                leftPower,
                leftBackPower,
                rightPower,
                rightBackPower
        );
    }

    @Override
    public void updateTelemetry(Telemetry telemetry) {

    }
}
