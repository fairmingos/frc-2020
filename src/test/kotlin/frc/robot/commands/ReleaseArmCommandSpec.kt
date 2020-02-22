package frc.robot.commands

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import edu.wpi.first.wpilibj.Timer
import frc.robot.subsystems.ArmSubsystem
import org.junit.*
import org.mockito.Mockito.*

class ReleaseArmCommandSpec {
    private lateinit var mockArmSubsystem: ArmSubsystem
    private lateinit var mockTimer: Timer
    private lateinit var releaseArmCommand: ReleaseArmCommand

    @Before
    fun setup () {
        mockArmSubsystem = mock()
        mockTimer = mock()
        releaseArmCommand = ReleaseArmCommand(mockArmSubsystem, mockTimer)
    }

    @Test
    fun fullPowerWhenTimerIsLessThanDuration () {
        // Arrange
        val fakeTime = releaseArmCommand.getDuration() - 0.1
        `when`(mockTimer.get()).thenReturn(fakeTime)
        // Act
        releaseArmCommand.execute()
        // Assert
        assert(releaseArmCommand.getPower() > 0.0)
    }
    @Test
    fun zeroPowerWhenTimerIsMoreThanDuration () {
        // Arrange
        val fakeTime = releaseArmCommand.getDuration() + 0.1
        `when`(mockTimer.get()).thenReturn(fakeTime)
        // Act
        releaseArmCommand.execute()
        // Assert
        assert(releaseArmCommand.getPower() == 0.0)
    }
    @Test
    fun zeroPowerWhenTimerIsDuration () {
        // Arrange
        val fakeTime = releaseArmCommand.getDuration()
        `when`(mockTimer.get()).thenReturn(fakeTime)
        // Act
        releaseArmCommand.execute()
        // Assert
        assert(releaseArmCommand.getPower() == 0.0)
    }
    @Test
    fun isNeverFinished () {
        // Arrange
        val fakeTime = releaseArmCommand.getDuration() + 2000
        `when`(mockTimer.get()).thenReturn(fakeTime)
        // Act
        val finished = releaseArmCommand.isFinished
        // Assert
        assert(!finished)
    }
    @Test
    fun callsSetMotorWithExpectedArguments () {
        // Arrange
        `when`(mockTimer.get()).thenReturn(0.0)
        // Act
        releaseArmCommand.execute()
        // Assert
        verify(mockArmSubsystem).setMotor(releaseArmCommand.getPower())
    }
    @Test
    fun startsTimerOnInitialize () {
        // Arrange
        /** mockTimer is initialized in @Before */
        // Act
        releaseArmCommand.initialize()
        // Assert
        verify(mockTimer).start()
    }
}