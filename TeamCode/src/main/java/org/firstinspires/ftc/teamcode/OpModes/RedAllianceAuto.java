package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "RedAllianceAuto")
public class RedAllianceAuto extends LinearOpMode {
    public DcMotor frontLeftMotor;
    public DcMotor backLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor backRightMotor;

    public int backLeftPos;
    public int backRightPos;
    public int frontLeftPos;
    public int frontRightPos;

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        drive(537.7, 537.7, 537.7, 537.7, 1);
        drive(537.7, 537.7, 537.7, 537.7, 1);
        drive(-537.7, 537.7, -537.7, 537.7, 1);

        if (isStopRequested()) {
            return;
        }
    }

    public void drive(double backLeftTarget, double backRightTarget, double frontLeftTarget,
                      double frontRightTarget, double speed){

        frontLeftMotor.setTargetPosition((int)frontLeftTarget);
        backLeftMotor.setTargetPosition((int)backLeftTarget);
        frontRightMotor.setTargetPosition((int)frontRightTarget);
        backRightMotor.setTargetPosition((int)backRightTarget);

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