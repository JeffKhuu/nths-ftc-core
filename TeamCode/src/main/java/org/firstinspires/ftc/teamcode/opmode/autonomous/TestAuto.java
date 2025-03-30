package org.firstinspires.ftc.teamcode.opmode.autonomous;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.RobotCentricDriveTrain;
import org.firstinspires.ftc.teamcode.utility.autonomous.AutoInstruction;
import org.firstinspires.ftc.teamcode.utility.autonomous.AutoRoutine;
import org.firstinspires.ftc.teamcode.utility.subsystems.DriveTrain;

@AutoRoutine(name = "Test")
public class TestAuto extends AutoInstruction {
    public TestAuto(LinearOpMode opMode, Pose2d startPose) {
        super(opMode, startPose);
    }

    @Override
    public Action getRoutine() {
        return new SequentialAction(
            driveTrain.getDrive().actionBuilder(startPose)
                    .lineToX(10)
                    .build()
        );
    }
}
