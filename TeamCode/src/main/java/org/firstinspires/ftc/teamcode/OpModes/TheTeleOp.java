package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Definitions.DriveTrain;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
@TeleOp(name = "MainTeleOp")
public class TheTeleOp extends LinearOpMode {

    private DcMotor intakeMotor;

    @Override
    public void runOpMode() throws InterruptedException{
        DriveTrain drive = new DriveTrain();
        drive.initDrivetrain(hardwareMap);
        intakeMotor = hardwareMap.get(DcMotor.class, "IntakeMotor");

        double forward, strafe, rotate;

        telemetry.addData("Status", "Ready");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        while (opModeIsActive()){
            forward = gamepad1.left_stick_y;
            strafe = -gamepad1.left_stick_x;
            rotate = gamepad1.right_stick_x;



            drive.driveFieldRelative(forward,strafe,rotate);

            if (gamepad1.right_bumper) {
                intakeMotor.setPower(1);
            }

            if (gamepad1.left_bumper) {
                intakeMotor.setPower(-1);
            }

            if (gamepad1.b) {
                intakeMotor.setPower(0);
            }
        }
    }
}
