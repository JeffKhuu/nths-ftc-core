package org.firstinspires.ftc.teamcode.utility.autonomous;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.subsystem.RobotCentricDriveTrain;
import org.firstinspires.ftc.teamcode.utility.subsystems.DriveTrain;

public abstract class AutoInstruction {

    public DriveTrain driveTrain;
    public Pose2d startPose;

    public AutoInstruction(LinearOpMode opMode, Pose2d startPose){
        this.startPose = startPose;
        driveTrain = new RobotCentricDriveTrain(opMode.hardwareMap, startPose);

        opMode.telemetry.addData("Status", "Systems Ready");
    }

    public AutoInstruction(){
    }

    /**
     * Abstract method to define a particular auto instruction's routine.
     * @return Autonomous routine as a RoadRunner action
     */
    public abstract Action getRoutine();
}
