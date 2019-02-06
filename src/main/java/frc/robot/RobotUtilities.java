package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RobotUtilities {
	
	public static final int CONFIG_TIMEOUT = 10;
	
	public static double constrain(double value, double minVal, double maxVal) {
		return Math.min(Math.max(value, minVal), maxVal);
	}
	
	/**
	 * Limits the given value to -1, 1
	 * 
	 * @param value
	 * @return
	 */
	public static double constrain(double value) {
		return constrain(value, -1, 1);
	}
	
	public static WPI_TalonSRX getTalonSRX(int port, String subsystem, String name) {
		WPI_TalonSRX talon = new WPI_TalonSRX(port);
		talon.setName(subsystem, name);
		configureDefaults(talon);
		return talon;
	}
	
	/**
	 * TODO: check error codes/timeouts
	 * 
	 * FIXME: we get Error -200: no new response errors pretty much
	 * every time on some Talon, but on different/random talons
	 * and different config calls. Might need longer timeout.
	 *
	 * @param talon The TalonSRX to configure
	 */
	public static void configureDefaults(WPI_TalonSRX talon) {
		// OUTPUTS
		talon.setInverted(false);
		talon.setNeutralMode(NeutralMode.Coast);
		talon.configPeakOutputForward(1, CONFIG_TIMEOUT);
		talon.configPeakOutputReverse(-1, CONFIG_TIMEOUT);
		talon.configNeutralDeadband(0.05, CONFIG_TIMEOUT);
		talon.configNominalOutputForward(0, CONFIG_TIMEOUT);
		talon.configNominalOutputReverse(0, CONFIG_TIMEOUT);
		
		// POWER CONTROL
		talon.enableCurrentLimit(false);
		talon.configContinuousCurrentLimit(0, CONFIG_TIMEOUT);
		talon.configPeakCurrentDuration(0, CONFIG_TIMEOUT);
		talon.configPeakCurrentLimit(0, CONFIG_TIMEOUT);
		talon.configVoltageCompSaturation(12, CONFIG_TIMEOUT);
		talon.enableVoltageCompensation(true);
		talon.configOpenloopRamp(0, CONFIG_TIMEOUT);
//		talon.configVoltageMeasurementFilter(5, CONFIG_TIMEOUT);

		// WPIlib FEATURES
//		talon.setExpiration(CONFIG_TIMEOUT);
		talon.setSafetyEnabled(false);
		
		// SENSORS
		talon.configForwardLimitSwitchSource(LimitSwitchSource.Deactivated, 
											 LimitSwitchNormal.Disabled, CONFIG_TIMEOUT);
		talon.configReverseLimitSwitchSource(LimitSwitchSource.Deactivated, 
											 LimitSwitchNormal.Disabled, CONFIG_TIMEOUT);
//		talon.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_50Ms, CONFIG_TIMEOUT);
//		talon.configVelocityMeasurementWindow(5, CONFIG_TIMEOUT);
		talon.configForwardSoftLimitEnable(false, CONFIG_TIMEOUT);
		talon.configForwardSoftLimitThreshold(0, CONFIG_TIMEOUT);
//		talon.configRemoteFeedbackFilter(deviceID, remoteSensorSource, remoteOrdinal, timeoutMs)
		talon.configReverseSoftLimitEnable(false, CONFIG_TIMEOUT);
		talon.configReverseSoftLimitThreshold(0, CONFIG_TIMEOUT);
		talon.configSelectedFeedbackSensor(FeedbackDevice.None, 0, CONFIG_TIMEOUT);
//		talon.configSensorTerm(sensorTerm, feedbackDevice, timeoutMs)
//		talon.overrideLimitSwitchesEnable(false);
//		talon.overrideSoftLimitsEnable(false);
		
		// MOTION PROFILING & MAGIC
		talon.changeMotionControlFramePeriod(5);
//		talon.configMotionAcceleration(1, CONFIG_TIMEOUT);
//		talon.configMotionCruiseVelocity(1, CONFIG_TIMEOUT);
		talon.configMotionProfileTrajectoryPeriod(5, CONFIG_TIMEOUT);
		
		// PID CONTROLS
		talon.config_kP(0, 0, CONFIG_TIMEOUT);
		talon.config_kI(0, 0, CONFIG_TIMEOUT);
		talon.config_kD(0, 0, CONFIG_TIMEOUT);
		talon.config_kF(0, 0, CONFIG_TIMEOUT);
//		talon.config_IntegralZone(0, 0, CONFIG_TIMEOUT);
		talon.configAllowableClosedloopError(0, 10, CONFIG_TIMEOUT);
		talon.configClosedloopRamp(0, CONFIG_TIMEOUT);
//		talon.configMaxIntegralAccumulator(0, 0, CONFIG_TIMEOUT);
//		talon.setIntegralAccumulator(0, 0, CONFIG_TIMEOUT);
	}
}