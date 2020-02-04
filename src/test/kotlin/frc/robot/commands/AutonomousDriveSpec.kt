package frc.robot.commands

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
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
    fun drivesWhenTimerIsLessThanDuration () {
        // arrange
        `when`(mockTimer.get()).thenReturn(0.0)
        // act
        commandScheduler.schedule(autonomousDriveCommand)
        commandScheduler.run()
        // assert
        verify(mockDriveSubsystem).arcadeDrive(anyDouble(), anyDouble())
    }
}