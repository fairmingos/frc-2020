package frc.robot.commands

import com.nhaarman.mockitokotlin2.*
import org.mockito.Mockito.`when`
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.CommandScheduler
import frc.robot.subsystems.DriveSubsystem
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.*
import java.util.function.Consumer

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
    fun drivesWhenTimerIsLessThanDuration () {
        // Arrange
        `when`(mockTimer.get()).thenReturn(0.0)
        // Act
        autonomousDriveCommand.execute()
        // Assert
        verify(mockDriveSubsystem).arcadeDrive(anyDouble(), anyDouble())
    }
    @Test
    fun doesNotDriveWhenTimerIsNotLessThanDuration () {
        // Arrange
        `when`(mockTimer.get()).thenReturn(autonomousDriveCommand.getDuration())
        // Act
        autonomousDriveCommand.execute()
        // Assert
        verify(mockDriveSubsystem, never()).arcadeDrive(anyDouble(), anyDouble())
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
}