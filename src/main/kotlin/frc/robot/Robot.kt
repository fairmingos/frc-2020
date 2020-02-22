/*----------------------------------------------------------------------------*/ /* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */ /* Open Source Software - may be modified and shared by FRC teams. The code   */ /* must be accompanied by the FIRST BSD license file in the root directory of */ /* the project.                                                               */ /*----------------------------------------------------------------------------*/
package frc.robot

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj2.command.CommandScheduler

// Basically ignore this class. 100% boilerplate. Thanks, Java.

class Robot : TimedRobot() {
    private lateinit var robotContainer: RobotContainer

    /**
     * This method is responsible for instantiating the RobotContainer
     */
    override fun robotInit () {
        robotContainer = RobotContainer()
    }

    /**
     * This method is responsible for running the scheduler, which executes commands
     */
    override fun robotPeriodic () {
        CommandScheduler.getInstance().run()
    }

    /**
     * This autonomous runs the autonomous command selected by your [RobotContainer] class.
     */
    override fun autonomousInit () {
        CommandScheduler.getInstance().cancelAll()
        robotContainer.autonomousCommand.schedule()
    }

    /**
     * This method is called when teleop starts and autonomous ends
     */
    override fun teleopInit () {
        CommandScheduler.getInstance().cancelAll()
        robotContainer.driveCommand.schedule()
    }

    /**
     * This method is called at the beginning of test mode
     */
    override fun testInit () {
        CommandScheduler.getInstance().cancelAll()
    }
}