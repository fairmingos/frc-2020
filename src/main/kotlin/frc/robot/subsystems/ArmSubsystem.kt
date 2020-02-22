package frc.robot.subsystems

import edu.wpi.first.wpilibj.SpeedController
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.robot.Mockable

@Mockable
class ArmSubsystem (private val motor: SpeedController) : SubsystemBase() {
    fun setMotor (power: Double) {
        motor.set(power)
    }
}