package frc.robot.commands

import com.nhaarman.mockitokotlin2.mock
import edu.wpi.first.wpilibj.Joystick
import frc.robot.subsystems.DriveSubsystem
import org.junit.*
import org.mockito.Mockito.*

class DriveCommandSpec {
    lateinit var mockJoystick: Joystick
    lateinit var driveSubsystem: DriveSubsystem
    lateinit var driveCommand: DriveCommand

    @Before
    fun beforeAll(){
        mockJoystick = mock(Joystick::class.java)
        driveSubsystem = DriveSubsystem(mock())
        driveCommand = DriveCommand(driveSubsystem, mockJoystick)
    }
    @Test
    fun processJoystickInputChangesSignOfY() {
        // Act
        val (fwd, rot) = driveCommand.processJoystickInput(1.0, 0.0)
        // Assert
        assert(fwd < 0)
    }
    @Test
    fun processJoystickInputUsesTopLimits() {
        // Act
        val (fwd, rot) = driveCommand.processJoystickInput(1.0, 1.0)
        // Assert
        assert(fwd == -driveCommand.fwdLimit)
        assert(rot == driveCommand.rotLimit)
    }
}