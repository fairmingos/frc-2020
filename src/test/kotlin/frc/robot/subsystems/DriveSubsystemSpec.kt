package frc.robot.subsystems

import edu.wpi.first.wpilibj.drive.DifferentialDrive
import org.junit.Test
import org.mockito.Mockito.*

class DriveSubsystemSpec {
    @Test
    fun testArcadeDrive(){
        // arrange
        val mockDrive: DifferentialDrive = mock(DifferentialDrive::class.java)
        val driveSubsystem = DriveSubsystem(mockDrive)

        driveSubsystem.arcadeDrive(0.5, 0.5)

        verify(mockDrive).arcadeDrive(0.5, 0.5)
    }
}