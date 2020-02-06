package frc.robot.commands

import com.nhaarman.mockitokotlin2.*
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import frc.robot.subsystems.DriveSubsystem
import org.junit.*
import org.mockito.Mockito.`when`

class DriveCommandSpec {
    private lateinit var mockJoystick: Joystick
    private lateinit var mockDriveSubsystem: DriveSubsystem
    private lateinit var driveCommand: DriveCommand

    @Before
    fun setup () {
        mockJoystick = mock()
        mockDriveSubsystem = mock()
        driveCommand = DriveCommand(mockDriveSubsystem, mockJoystick)
    }
    @Test
    fun processJoystickInputChangesSignOfY () {
        // Act
        val (fwd1) = driveCommand.processJoystickInput(1.0, 0.0)
        val (fwd2) = driveCommand.processJoystickInput(-1.0, 0.0)
        // Assert
        assert(fwd1 < 0)
        assert(fwd2 > 0)
    }
    @Test
    fun processJoystickInputUsesTopLimits () {
        // Act
        val (fwd, rot) = driveCommand.processJoystickInput(1.0, 1.0)
        // Assert
        assert(fwd == -driveCommand.fwdLimit)
        assert(rot == driveCommand.rotLimit)
    }
    @Test
    fun callsArcadeDriveWithExpectedArguments () {
        // Arrange
        val mockJoystickY = 0.5
        val mockJoystickX = 0.05
        `when`(mockJoystick.getY()).thenReturn(mockJoystickY)
        `when`(mockJoystick.getX()).thenReturn(mockJoystickX)
        val (expectedFwd, expectedRot) = driveCommand.processJoystickInput(
            mockJoystickY, mockJoystickX
        )
        // Act
        driveCommand.execute()
        // Assert
        verify(mockDriveSubsystem).arcadeDrive(expectedFwd, expectedRot)
    }
}