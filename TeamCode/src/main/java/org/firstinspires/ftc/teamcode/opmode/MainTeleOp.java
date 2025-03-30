package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.RobotCentricDriveTrain;
import org.firstinspires.ftc.teamcode.utility.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.utility.telemetry.TelemetryMaster;

// Specifies the name to show in the Driver Station app and puts it at the top of the list with the "!" group.
@TeleOp(name = "Main TeleOp", group = "!")
public class MainTeleOp extends OpMode {
    private DriveTrain driveTrain;
    private final Pose2d start = new Pose2d(0, 0, Math.toRadians(0));

    private TelemetryMaster telemetryMaster;

    @Override
    public void init() {
        driveTrain =  new RobotCentricDriveTrain(hardwareMap, start);

        telemetryMaster = new TelemetryMaster(telemetry);
        telemetryMaster
                .subscribe(driveTrain);

    }

    @Override
    public void loop() {
        telemetryMaster.update();

        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        driveTrain.drive(x, y, turn);
    }
}
