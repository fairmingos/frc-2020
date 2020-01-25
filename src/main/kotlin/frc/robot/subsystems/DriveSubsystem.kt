package frc.robot.subsystems

import edu.wpi.first.wpilibj.PWMVictorSPX
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.SpeedController
import edu.wpi.first.wpilibj.SpeedControllerGroup
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.robot.Constants
import frc.robot.commands.DriveCommand

class DriveSubsystem(private val drive: DifferentialDrive) : SubsystemBase() {
    fun processJoystickInput(input: Pair<Double, Double>): Pair<Double, Double> {
        // TODO
        return Pair<Double, Double>(0.0, 0.0)
    }

    fun arcadeDrive(fwd: Double, rot: Double) {
        drive.arcadeDrive(fwd, rot)
    }
}