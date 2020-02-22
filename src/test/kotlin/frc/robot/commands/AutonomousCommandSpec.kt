package frc.robot.commands

import com.nhaarman.mockitokotlin2.*
import org.mockito.Mockito.`when`
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.CommandScheduler
import frc.robot.subsystems.DriveSubsystem
import org.junit.Before
import org.junit.Test

class AutonomousCommandSpec {
    private lateinit var mockDriveSubsystem: DriveSubsystem
    private lateinit var mockTimer: Timer
    private lateinit var autonomousCommand: AutonomousCommand
    private lateinit var commandScheduler: CommandScheduler

    @Before
    fun setup () {
        commandScheduler = CommandScheduler.getInstance()
        mockDriveSubsystem = mock()
        mockTimer = mock()
        autonomousCommand = AutonomousCommand(mockDriveSubsystem, mockTimer)
    }
    @Test
    fun fullPowerWhenTimerIsLessThanDuration () {
        // Arrange
        val fakeTime = autonomousCommand.getDuration() - 0.1
        `when`(mockTimer.get()).thenReturn(fakeTime)
        // Act
        autonomousCommand.execute()
        // Assert
        assert(autonomousCommand.getPower() > 0.0)
    }
    @Test
    fun zeroPowerWhenTimerIsMoreThanDuration () {
        // Arrange
        val fakeTime = autonomousCommand.getDuration() + 0.1
        `when`(mockTimer.get()).thenReturn(fakeTime)
        // Act
        autonomousCommand.execute()
        // Assert
        assert(autonomousCommand.getPower() == 0.0)
    }
    @Test
    fun zeroPowerWhenTimerIsDuration () {
        // Arrange
        val fakeTime = autonomousCommand.getDuration()
        `when`(mockTimer.get()).thenReturn(fakeTime)
        // Act
        autonomousCommand.execute()
        // Assert
        assert(autonomousCommand.getPower() == 0.0)
    }
    @Test
    fun callsArcadeDriveWithExpectedArguments () {
        // Arrange
        `when`(mockTimer.get()).thenReturn(0.0)
        // Act
        autonomousCommand.execute()
        // Assert
        verify(mockDriveSubsystem).arcadeDrive(autonomousCommand.getPower(), 0.0)
    }
    @Test
    fun startsTimerOnInitialize () {
        // Arrange
        /** mockTimer is initialized in @Before */
        // Act
        autonomousCommand.initialize()
        // Assert
        verify(mockTimer).start()
    }
    @Test
    fun isNeverFinished () {
        // Arrange
        val fakeTime = autonomousCommand.getDuration() + 2000
        `when`(mockTimer.get()).thenReturn(fakeTime)
        // Act
        val finished = autonomousCommand.isFinished
        // Assert
        assert(!finished)
    }
}