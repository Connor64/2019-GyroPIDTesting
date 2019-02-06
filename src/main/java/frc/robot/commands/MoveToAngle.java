package frc.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;

public class MoveToAngle extends PIDCommand {
    private static final double P = 1.0, I = 0.0, D = 0.0;

    public MoveToAngle(double angle) {
        super(P, I, D);
    }

    @Override
    protected double returnPIDInput() {
        return Robot.gyro.getGyro().getAngle();
        
    }

    @Override
    protected void usePIDOutput(double output) {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}