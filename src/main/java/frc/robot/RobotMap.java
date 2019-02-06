/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static final int DRIVE_LEFT_PRIMARY = 25;
	public static final int DRIVE_LEFT_SECONDARY = 24;
	public static final int DRIVE_RIGHT_PRIMARY = 10;
	public static final int DRIVE_RIGHT_SECONDARY = 11;
	public static final int INTAKE_LEFT = 14;
	public static final int INTAKE_RIGHT = 15;
	public static final int POWER_PACK_PRIMARY = 23;
	public static final int POWER_PACK_SECONDARY = 22;
	public static final int POWER_PACK_TERTIARY = 21;
	public static final int POWER_PACK_QUATERNARY = 20;
	public static final int TILT = 13;
	
	// Pneumatics (PCM)
	public static final int DRIVE_TRANSMISSION = 7;
	public static final int ARMS = 6;
	public static final int WINCH_TRANSMISSION = 5;
	public static final int WINCH_BRAKE = 4;
  public static final int HOOK = 0;
  
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
