package frc.robot.commands

import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.subsystems.ArmSubsystem

class ReleaseArmCommand (
        private val armSubsystem: ArmSubsystem,
        private val timer: Timer
) : CommandBase() {
    private val duration = 1.0 // seconds
    private val initialPower = 1.0
    private var power = initialPower

    fun getDuration () = duration
    fun getPower () = power

    /**
     * The initial subroutine of a command.  Called once when the command is initially scheduled.
     */
    override fun initialize () {
        timer.start()
    }

    /**
     * The main body of a command.  Called repeatedly while the command is scheduled.
     * (That is, it is called repeatedly until [.isFinished]) returns true.)
     */
    override fun execute () {
        if (timer.get() >= duration) {
            power = 0.0
        }
        armSubsystem.setMotor(power)
    }

    /**
     * Returns whether this command has finished. Once a command finishes -- indicated by
     * this method returning true -- the scheduler will call its [.end] method.
     * @return whether this command has finished.
     */
    override fun isFinished (): Boolean = false

    /**
     * The action to take when the command ends. Called when either the command
     * @param interrupted whether the command was interrupted/canceled
     */
    override fun end (interrupted: Boolean) {}
}