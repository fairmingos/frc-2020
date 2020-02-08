package frc.robot.commands

import com.nhaarman.mockitokotlin2.*
import org.mockito.Mockito.`when`
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.CommandScheduler
import frc.robot.subsystems.DriveSubsystem
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.*

class AutonomousDriveSpec {
    private lateinit var mockDriveSubsystem: DriveSubsystem
    private lateinit var mockTimer: Timer
    private lateinit var autonomousDriveCommand: AutonomousDriveCommand
    private lateinit var commandScheduler: CommandScheduler

    @Before
    fun setup () {
        commandScheduler = CommandScheduler.getInstance()
        mockDriveSubsystem = mock()
        mockTimer = mock()
        autonomousDriveCommand = AutonomousDriveCommand(mockDriveSubsystem, mockTimer)
    }
    @Test
    fun isNotFinishedWhenTimerIsLessThanDuration () {
        // Arrange
        `when`(mockTimer.get()).thenReturn(0.0)
        // Act
        val finished = autonomousDriveCommand.isFinished
        // Assert
        assert(!finished)
    }
    @Test
    fun isFinishedWhenTimerIsMoreThanDuration () {
        // Arrange
        `when`(mockTimer.get()).thenReturn(autonomousDriveCommand.getDuration())
        // Act
        val finished = autonomousDriveCommand.isFinished
        // Assert
        assert(finished)
    }
    @Test
    fun callsArcadeDriveWithExpectedArguments () {
        // Arrange
        `when`(mockTimer.get()).thenReturn(0.0)
        // Act
        autonomousDriveCommand.execute()
        // Assert
        verify(mockDriveSubsystem).arcadeDrive(autonomousDriveCommand.getPower(), 0.0)
    }
    @Test
    fun startsTimerOnInitialize () {
        // Arrange
        /* mockTimer is initialized in @Before */
        // Act
        autonomousDriveCommand.initialize()
        // Assert
        verify(mockTimer).start()
    }
    @Test
    fun stopsArcadeDriveOnEnd () {
        // Arrange
        /* mockDriveSubsystem is initialized in @Before */
        // Act
        autonomousDriveCommand.end(false)
        // Assert
        verify(mockDriveSubsystem).arcadeDrive(0.0, 0.0)
    }
}