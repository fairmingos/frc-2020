package frc.robot.commands

import com.nhaarman.mockitokotlin2.*
import frc.robot.OI
import frc.robot.subsystems.DriveSubsystem
import org.junit.*
import org.mockito.Mockito.`when`

class DriveCommandSpec {
    private lateinit var mockOI: OI
    private lateinit var mockDriveSubsystem: DriveSubsystem
    private lateinit var driveCommand: DriveCommand

    @Before
    fun setup () {
        mockOI = mock()
        mockDriveSubsystem = mock()
        driveCommand = DriveCommand(mockDriveSubsystem, mockOI)
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
        `when`(mockOI.getFwd()).thenReturn(0.5)
        `when`(mockOI.getRot()).thenReturn(0.05)
        `when`(mockOI.getSlider()).thenReturn(1.0)
        val (expectedFwd, expectedRot) = driveCommand.processJoystickInput(
                0.5, 0.05)
        // Act
        driveCommand.execute()
        // Assert
        verify(mockDriveSubsystem).arcadeDrive(expectedFwd, expectedRot)
    }
    @Test
    fun isReversedWhenSliderIsBack () {
        // Arrange
        `when`(mockOI.getSlider()).thenReturn(-1.0)
        // Act
        val reversed = driveCommand.isReversed()
        // Assert
        assert(reversed)
    }
    @Test
    fun isNotReversedWhenSliderIsForward () {
        // Arrange
        `when`(mockOI.getSlider()).thenReturn(1.0)
        // Act
        val reversed = driveCommand.isReversed()
        // Assert
        assert(!reversed)
    }
    @Test
    fun processInputReversesFwdWithSlider () {
        // Arrange
        val (fwd) = driveCommand.processJoystickInput(1.0, 0.0)
        driveCommand.reversed = true
        // Act
        val (revFwd) = driveCommand.processJoystickInput(1.0, 0.0)
        // Assert
        assert(fwd == -revFwd)
    }
}