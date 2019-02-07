package frc.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class MoveToAngle extends PIDCommand {
    private double p, i, d;
    private double angle; 
    private int c = 0;
    // fine tune these values

    public MoveToAngle(double angle, double p, double i, double d) {
        super(p, i, d);
        this.angle = angle;
        getPIDController().setAbsoluteTolerance(.5);
        /*
         * these values (P, I, D) are used in PIDCommand: 
         * public PIDCommand(String name, double p, double i, double d) { 
         *      super(name); 
         *      m_controller = new PIDController(p, i, d, m_source, m_output); 
         * }
         */
    }

   
    @Override 
    protected void initialize() {
        setSetpoint(angle);
    }
    @Override
    protected double returnPIDInput() {
        return Robot.gyro.getGyro().getAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        if(output > 1) {
            output = 1;
        } else if (output < -1) {
            output = -1;
        }
        Robot.drivetrain.setPower(output, output);
    }

    @Override
    protected void execute() {
    	if (getPIDController().onTarget()) {
    		c++;
    	} else {
    		c = 0;
        }
         
    }

    @Override
    protected boolean isFinished() {
        return c > 3;
    }

    @Override
    protected void end() {
        Robot.drivetrain.stop();
    }
}