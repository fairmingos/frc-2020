package frc.robot.subsystems

import edu.wpi.first.wpilibj.drive.DifferentialDrive
import frc.robot.subsystems.DriveSubsystem
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class DriveSubsystemSpec {
    @Test
    fun testProcessJoystickInputFwdChangeSign(){
        val drive: DifferentialDrive = mock(DifferentialDrive::class.java)

        val driveSubsystem = DriveSubsystem(drive)

        val input = Pair<Double, Double>(1.0, 0.0)

        val (fwd, rot) = driveSubsystem.processJoystickInput(input)

        assert(fwd < 0)
    }
}