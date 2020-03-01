package frc.robot.subsystems

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import edu.wpi.first.wpilibj.Spark
import org.junit.Test

class ArmSubsystemSpec {
    @Test
    fun testSetMotor () {
        // Arrange
        val mockMotor: Spark = mock()
        val armSubsystem = ArmSubsystem(mockMotor)
        // Act
        armSubsystem.setMotor(0.5)
        // Assert
        verify(mockMotor).set(0.5)
    }
}