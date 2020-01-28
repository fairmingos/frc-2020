/*----------------------------------------------------------------------------*/ /* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */ /* Open Source Software - may be modified and shared by FRC teams. The code   */ /* must be accompanied by the FIRST BSD license file in the root directory of */ /* the project.                                                               */ /*----------------------------------------------------------------------------*/
package frc.robot

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.SpeedController
import edu.wpi.first.wpilibj.SpeedControllerGroup
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj2.command.Command
import frc.robot.commands.DriveCommand
import frc.robot.subsystems.DriveSubsystem

/**
 * This class is responsible for defining subsystems, commands, and button bindings for commands
 */

// RobotContainer must be a class for unit testing

class RobotContainer {
    val autonomousCommand: Command? = null
    val joystick = Joystick(Constants.JOYSTICK_1)

    /** Motors **/
    private val leftMotor0: SpeedController = Spark(Constants.LEFT_MOTOR_1)
    private val rightMotor0: SpeedController = Spark(Constants.RIGHT_MOTOR_1)

    private val leftSpeedControllerGroup = SpeedControllerGroup(leftMotor0)
    private val rightSpeedControllerGroup = SpeedControllerGroup(rightMotor0)

    private val drive = DifferentialDrive(leftSpeedControllerGroup, rightSpeedControllerGroup)

    /** Subsystems **/
    private val driveSubsystem = DriveSubsystem(drive)

    /** Commands **/
    // default commands on teleop
    private val driveCommand = DriveCommand(driveSubsystem)

    init {
      driveSubsystem.defaultCommand = driveCommand
    }
    /** Joystick Buttons **/

}
