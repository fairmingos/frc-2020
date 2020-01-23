/*----------------------------------------------------------------------------*/ /* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */ /* Open Source Software - may be modified and shared by FRC teams. The code   */ /* must be accompanied by the FIRST BSD license file in the root directory of */ /* the project.                                                               */ /*----------------------------------------------------------------------------*/
package frc.robot

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj2.command.Command
import frc.robot.commands.DriveCommand
import frc.robot.subsystems.DriveSubsystem

/**
 * This class is responsible for defining subsystems, commands, and button bindings for commands
 */

object RobotContainer {
    val autonomousCommand: Command? = null
    val joystick = Joystick(Constants.JOYSTICK_1)
    /** Commands **/
    // default commands on teleop
    private val driveCommand = DriveCommand(DriveSubsystem)

    /** Joystick Buttons **/

}
