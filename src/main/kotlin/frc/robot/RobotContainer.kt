/*----------------------------------------------------------------------------*/ /* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */ /* Open Source Software - may be modified and shared by FRC teams. The code   */ /* must be accompanied by the FIRST BSD license file in the root directory of */ /* the project.                                                               */ /*----------------------------------------------------------------------------*/
package frc.robot

import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj2.command.button.JoystickButton
import frc.robot.commands.AutonomousDriveCommand
import frc.robot.commands.DriveCommand
import frc.robot.commands.ReleaseArmCommand
import frc.robot.subsystems.ArmSubsystem
import frc.robot.subsystems.DriveSubsystem

/**
 * This class is responsible for defining subsystems, commands, and button bindings for commands
 */

// RobotContainer must be a class for unit testing

class RobotContainer {

    private val joystick = Joystick(Constants.JOYSTICK_1)
    private val oi = OI(joystick)

    /** Motors **/
    private val leftMotor1: SpeedController = Spark(Constants.LEFT_MOTOR_1)
    private val leftMotor2: SpeedController = Spark(Constants.LEFT_MOTOR_2)
    private val rightMotor1: SpeedController = Spark(Constants.RIGHT_MOTOR_1)
    private val rightMotor2: SpeedController = Spark(Constants.RIGHT_MOTOR_2)

    private val armMotor: SpeedController = Spark(Constants.ARM_MOTOR)

    private val leftSpeedControllerGroup = SpeedControllerGroup(
            leftMotor1, leftMotor2
    )
    private val rightSpeedControllerGroup = SpeedControllerGroup(
            rightMotor1, rightMotor2
    )

    private val drive = DifferentialDrive(leftSpeedControllerGroup, rightSpeedControllerGroup)

    /** Subsystems **/
    private val driveSubsystem = DriveSubsystem(drive)
    private val armSubsystem = ArmSubsystem(armMotor)

    /** Autonomous Command **/
    val autonomousCommand = AutonomousDriveCommand(driveSubsystem, Timer())
    /** Teleop Commands **/
    val driveCommand = DriveCommand(driveSubsystem, oi)

    init {
        val releaseArmButton = JoystickButton(joystick, Constants.RELEASE_ARM_BUTTON)
        releaseArmButton.whenPressed(ReleaseArmCommand(armSubsystem, Timer()))
    }

}
