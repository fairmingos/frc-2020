package frc.robot.commands

import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.subsystems.DriveSubsystem

class AutonomousCommand (
    private val driveSubsystem: DriveSubsystem,
    private val timer: Timer
) : CommandBase() {
    private val duration = 2.0
    private val initialPower = 0.5
    private var power = initialPower

    fun getDuration (): Double {
        return duration
    }
    fun getPower (): Double {
        return power
    }

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
        driveSubsystem.arcadeDrive(power, 0.0)
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
    override fun end (interrupted: Boolean) {
        driveSubsystem.arcadeDrive(0.0, 0.0)
    }
}