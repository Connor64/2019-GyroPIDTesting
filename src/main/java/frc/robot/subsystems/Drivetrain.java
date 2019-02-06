/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  TalonSRX rightPrimary;
  TalonSRX rightSecondary;
  TalonSRX leftPrimary;
  TalonSRX leftSecondary;
  private static Drivetrain instance;

  private Drivetrain(){
    rightPrimary = new TalonSRX(RobotMap.DRIVE_RIGHT_PRIMARY);
    rightSecondary = new TalonSRX(RobotMap.DRIVE_RIGHT_SECONDARY);
    leftPrimary = new TalonSRX(RobotMap.DRIVE_LEFT_PRIMARY);
    leftSecondary = new TalonSRX(RobotMap.DRIVE_LEFT_SECONDARY);

    rightSecondary.follow(rightPrimary);
    leftSecondary.follow(leftPrimary);
  }

  public static Drivetrain getInstance() {
    if (instance == null) {
      instance = new Drivetrain();
    }
    return instance;
  }

  public void setRightPowers(double power) {
    rightPrimary.set(ControlMode.PercentOutput, power);
  }

  public void setLeftPowers(double power) {
    leftPrimary.set(ControlMode.PercentOutput, power);
  }

  public void setPower(double rightPower, double leftPower) {
    setRightPowers(rightPower);
    setLeftPowers(leftPower);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void stop() {
    setPower(0, 0);
  }
}