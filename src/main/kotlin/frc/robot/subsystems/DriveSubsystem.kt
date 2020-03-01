package frc.robot.subsystems

import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.robot.Mockable

@Mockable
class DriveSubsystem (private val drive: DifferentialDrive) : SubsystemBase() {
    fun arcadeDrive (fwd: Double, rot: Double) {
        drive.arcadeDrive(fwd, rot)
    }
}