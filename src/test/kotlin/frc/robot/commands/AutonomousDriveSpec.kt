package frc.robot.commands

import com.nhaarman.mockitokotlin2.mock
import frc.robot.subsystems.DriveSubsystem
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class AutonomousDriveSpec {
    private lateinit var mockDriveSubsystem: DriveSubsystem
    private lateinit var autonomousDriveCommand: AutonomousDriveCommand

    @Before
    fun beforeAll () {
        mockDriveSubsystem = DriveSubsystem(mock())
        autonomousDriveCommand = AutonomousDriveCommand(mockDriveSubsystem)
    }
    @Test
    fun test
}