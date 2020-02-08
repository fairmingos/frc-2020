package frc.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.OI
import frc.robot.subsystems.DriveSubsystem

class DriveCommand(
        private val driveSubsystem: DriveSubsystem,
        private val oi: OI
) : CommandBase() {
    val fwdLimit: Double = 1.0
    val rotLimit: Double = 1.0

    var reversed = false

    fun processJoystickInput(fwd: Double, rot: Double): Pair<Double, Double> {
        var fwdDirection = if (reversed) -1 else 1
        return Pair(
            -fwd * fwdLimit * fwdDirection,
            rot * rotLimit
        )
    }

    fun isReversed(): Boolean {
        return oi.getSlider() < 0
    }

    override fun initialize() {}

    override fun execute() {
        reversed = isReversed()

        val (fwd, rot) = processJoystickInput(oi.getFwd(), oi.getRot())

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