package frc.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.OI
import frc.robot.subsystems.DriveSubsystem
import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.sign

class DriveCommand (
        private val driveSubsystem: DriveSubsystem,
        private val oi: OI
) : CommandBase() {
    val fwdLimit: Double = 1.0
    val rotLimit: Double = 1.0

    var reversed = false

    /**
     * Scales, limits, or transforms in some way raw input from joystick
     */
    fun processJoystickInput (
            rawFwd: Double,
            rawRot: Double
    ): Pair<Double, Double> {
        // Initialize variables to hold processed input
        var fwd = rawFwd.powWithSign(2) * fwdLimit
        var rot = rawRot.powWithSign(2) * rotLimit
        // Change forward direction if controls are reversed
        if (reversed) fwd *= -1
        // Return processed input
        return Pair(fwd, rot)
    }

    /**
     * Returns whether the joystick slider is pulled back
     */
    fun isReversed (): Boolean {
        // getSlider() returns a value from -1 to 1
        return oi.getSlider() < 0
    }

    /** Override methods: */

    /**
     * The initial subroutine of a command.  Called once when the command is initially scheduled.
     */
    override fun initialize () {}

    /**
     * The main body of a command.  Called repeatedly while the command is scheduled.
     * (That is, it is called repeatedly until [.isFinished]) returns true.)
     */
    override fun execute () {
        // Sets whether the controls should be reversed
        // (referenced in processJoystickInput)
        reversed = isReversed()
        // Gets raw vectors from joystick
        val rawFwd = oi.getFwd()
        val rawRot = oi.getRot()
        // Gets processed vectors from processJoystickInput
        val (fwd, rot) = processJoystickInput(rawFwd, rawRot)
        // Calls subsystem with processed vectors
        driveSubsystem.arcadeDrive(fwd, rot)
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

    init {
        addRequirements(driveSubsystem)
    }
}

fun Double.powWithSign (n: Int): Double {
    return this.pow(n).absoluteValue * this.sign
}