package frc.robot.subsystems

import com.nhaarman.mockitokotlin2.*
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import org.junit.Test

class DriveSubsystemSpec {
    @Test
    fun testArcadeDrive () {
        // Arrange
        val mockDrive: DifferentialDrive = mock()
        val driveSubsystem = DriveSubsystem(mockDrive)
        // Act
        driveSubsystem.arcadeDrive(0.5, 0.5)
        // Assert
        verify(mockDrive).arcadeDrive(0.5, 0.5)
    }
}