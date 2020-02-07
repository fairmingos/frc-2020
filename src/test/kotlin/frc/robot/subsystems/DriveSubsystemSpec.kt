package frc.robot.subsystems

import edu.wpi.first.wpilibj.drive.DifferentialDrive
import org.junit.Test
import org.mockito.Mockito.*

class DriveSubsystemSpec {
    @Test
    fun testArcadeDrive (){
        // Arrange
        val mockDrive: DifferentialDrive = mock(DifferentialDrive::class.java)
        val driveSubsystem = DriveSubsystem(mockDrive)
        // Act
        driveSubsystem.arcadeDrive(0.5, 0.5)
        // Assert
        verify(mockDrive).arcadeDrive(0.5, 0.5)
    }
}