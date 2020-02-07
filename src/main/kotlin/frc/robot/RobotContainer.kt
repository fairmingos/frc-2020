/*----------------------------------------------------------------------------*/ /* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */ /* Open Source Software - may be modified and shared by FRC teams. The code   */ /* must be accompanied by the FIRST BSD license file in the root directory of */ /* the project.                                                               */ /*----------------------------------------------------------------------------*/
package frc.robot

import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import frc.robot.commands.AutonomousDriveCommand
import frc.robot.commands.DriveCommand
import frc.robot.subsystems.DriveSubsystem

/**
 * This class is responsible for defining subsystems, commands, and button bindings for commands
 */

// RobotContainer must be a class for unit testing

class RobotContainer {

    private val joystick = Joystick(Constants.JOYSTICK_1)
    private val oi = OI(joystick)

    /** Motors **/
    private val leftMotor0: SpeedController = Spark(Constants.LEFT_MOTOR_1)
    private val rightMotor0: SpeedController = Spark(Constants.RIGHT_MOTOR_1)

    private val leftSpeedControllerGroup = SpeedControllerGroup(leftMotor0)
    private val rightSpeedControllerGroup = SpeedControllerGroup(rightMotor0)

    private val drive = DifferentialDrive(leftSpeedControllerGroup, rightSpeedControllerGroup)

    /** Subsystems **/
    private val driveSubsystem = DriveSubsystem(drive)

    /** Autonomous Command **/
    val autonomousCommand = AutonomousDriveCommand(driveSubsystem, Timer())
    /** Teleop Commands **/
    val driveCommand = DriveCommand(driveSubsystem, oi)

}
