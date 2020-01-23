package frc.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.RobotContainer
import frc.robot.subsystems.DriveSubsystem

class DriveCommand(private val driveSubsystem: DriveSubsystem) : CommandBase() {
    override fun initialize() {}
    override fun execute() {
        val fwd = RobotContainer.joystick.y
        val rot = RobotContainer.joystick.x

        driveSubsystem.arcadeDrive(fwd, rot)
    }
    override fun isFinished(): Boolean {
        return false
    }

    override fun end(interrupted: Boolean) {}

    init {
        addRequirements(driveSubsystem)
    }
}