package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class RedAllianceAuto extends LinearOpMode {
    public DcMotor frontLeftMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backRightMotor = null;

    public int backLeftPos;
    public int backRightPos;
    public int frontLeftPos;
    public int frontRightPos;

    @Override
    public void runOpMode() throws InterruptedException{
        frontLeftMotor = hardwareMap.get(DcMotor.class, "FrontLeftMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "BackLeftMotor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "FrontRightMotor");
        backRightMotor = hardwareMap.get(DcMotor.class, "BackRightMotor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        drive(537.7, 537.7, 537.7, 537.7, 1);
        drive(537.7, 537.7, 537.7, 537.7, 1);
        drive(67.2125, -67.2125, 67.2125, -67.2125,
                1);

        if (isStopRequested()) {
            return;
        }
    }

    public void drive(double backLeftTarget, double backRightTarget, double frontLeftTarget,
                      double frontRightTarget, double speed){
        backLeftPos += backLeftTarget;
        backRightPos += backRightTarget;
        frontLeftPos += frontLeftTarget;
        frontRightPos += frontRightTarget;

        frontLeftMotor.setTargetPosition(backLeftPos);
        backLeftMotor.setTargetPosition(backRightPos);
        frontRightMotor.setTargetPosition(frontLeftPos);
        backRightMotor.setTargetPosition(frontRightPos);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeftMotor.setPower(speed);
        backLeftMotor.setPower(speed);
        frontRightMotor.setPower(speed);
        backRightMotor.setPower(speed);
    }
}