package frc.robot.subsystems

import edu.wpi.first.wpilibj.PWMVictorSPX
import edu.wpi.first.wpilibj.SpeedController
import edu.wpi.first.wpilibj.SpeedControllerGroup
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.robot.Constants

object DriveSubsystem : SubsystemBase() {
    private val leftMotor1: SpeedController = PWMVictorSPX(Constants.LEFT_MOTOR_1)
    private val rightMotor1: SpeedController = PWMVictorSPX(Constants.RIGHT_MOTOR_1)

    private val leftSpeedControllerGroup = SpeedControllerGroup(leftMotor1)
    private val rightSpeedControllerGroup = SpeedControllerGroup(rightMotor1)

    private val drive = DifferentialDrive(leftSpeedControllerGroup, rightSpeedControllerGroup)

    fun arcadeDrive(fwd: Double, rot: Double) {
        drive.arcadeDrive(fwd, rot)
    }
}