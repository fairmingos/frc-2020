package frc.robot.commands

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import edu.wpi.first.wpilibj.Timer
import frc.robot.subsystems.ArmSubsystem
import org.junit.*
import org.mockito.Mockito

class ReleaseArmSpec {
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
    fun isNotFinishedWhenTimerIsLessThanDuration () {
        // Arrange
        Mockito.`when`(mockTimer.get()).thenReturn(0.0)
        // Act
        val finished = releaseArmCommand.isFinished
        // Assert
        assert(!finished)
    }
    @Test
    fun isFinishedWhenTimerIsMoreThanDuration () {
        // Arrange
        Mockito.`when`(mockTimer.get()).thenReturn(releaseArmCommand.getDuration())
        // Act
        val finished = releaseArmCommand.isFinished
        // Assert
        assert(finished)
    }
    @Test
    fun callsSetMotorWithExpectedArguments () {
        // Arrange
        Mockito.`when`(mockTimer.get()).thenReturn(0.0)
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