package frc.robot.commands

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.RobotContainer
import frc.robot.subsystems.DriveSubsystem

class DriveCommand(
        private val driveSubsystem: DriveSubsystem,
        private val joystick: Joystick
) : CommandBase() {
    val fwdLimit: Double = 0.8
    val rotLimit: Double = 0.8

    fun processJoystickInput(fwd: Double, rot: Double): Pair<Double, Double> {
        return Pair(
            -fwd * fwdLimit,
            rot * rotLimit
        )
    }

    override fun initialize() {}

    override fun execute() {
        val fwd = joystick.y
        val rot = joystick.x

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