/*----------------------------------------------------------------------------*/ /* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */ /* Open Source Software - may be modified and shared by FRC teams. The code   */ /* must be accompanied by the FIRST BSD license file in the root directory of */ /* the project.                                                               */ /*----------------------------------------------------------------------------*/
package frc.robot

import edu.wpi.first.wpilibj2.command.Command
import frc.robot.commands.ExampleCommand
import frc.robot.subsystems.ExampleSubsystem

/**
 * Actual robot class...
 */

class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private val exampleSubsystem = ExampleSubsystem()// An ExampleCommand will run in autonomous
    val autonomousCommand = ExampleCommand(exampleSubsystem)

    private fun configureButtonBindings() {}

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    init { // Configure the button bindings
        configureButtonBindings()
    }
}