package frc.robot.commands

import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.subsystems.ArmSubsystem

class ReleaseArmCommand(
        private val armSubsystem: ArmSubsystem,
        private val timer: Timer
) : CommandBase() {
    private val duration: Double = 1.0 // seconds
    private val power: Double = 1.0

    fun getDuration () = duration
    fun getPower () = power

    override fun initialize() {
        timer.start()
    }
    override fun execute() {
        armSubsystem.setMotor(power)
    }
    override fun isFinished(): Boolean {
        return timer.get() >= duration
    }

    override fun end(interrupted: Boolean) {}
}