package frc.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;

public class MoveToAngle extends PIDCommand {
    private static final double P = 1.0, I = 0.0, D = 0.0;
    // fine tune these values

    public MoveToAngle(double angle) {
        super(P, I, D);

        /*
         * these values (P, I, D) are used in PIDCommand: 
         * public PIDCommand(String name, double p, double i, double d) { 
         *      super(name); 
         *      m_controller = new PIDController(p, i, d, m_source, m_output); 
         * }
         */
    }

    @Override
    protected double returnPIDInput() {
        return Robot.gyro.getGyro().getAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.drivetrain.setPower(output, -output);
    }

    @Override
    protected boolean isFinished() {
        return (Robot.gyro.getGyro().getAngle() >= 40);
    }

    @Override
    protected void end() {
        Robot.drivetrain.stop();
    }
}