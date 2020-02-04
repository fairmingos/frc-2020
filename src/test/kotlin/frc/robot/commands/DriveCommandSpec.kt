package frc.robot.commands

import com.nhaarman.mockitokotlin2.mock
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import frc.robot.subsystems.DriveSubsystem
import org.junit.*
import org.mockito.Mockito.*

class DriveCommandSpec {
    private lateinit var mockJoystick: Joystick
    private lateinit var mockDifferentialDrive: DifferentialDrive
    private lateinit var mockDriveSubsystem: DriveSubsystem
    private lateinit var driveCommand: DriveCommand

    @Before
    fun setup (){
        mockJoystick = mock(Joystick::class.java)
        mockDifferentialDrive = mock(DifferentialDrive::class.java)
        mockDriveSubsystem = DriveSubsystem(mockDifferentialDrive)
//        driveSubsystem = DriveSubsystem(mock())
        driveCommand = DriveCommand(mockDriveSubsystem, mockJoystick)
    }
    @Test
    fun processJoystickInputChangesSignOfY() {
        // Act
        val (fwd) = driveCommand.processJoystickInput(1.0, 0.0)
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