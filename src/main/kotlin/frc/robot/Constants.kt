/*----------------------------------------------------------------------------*/ /* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */ /* Open Source Software - may be modified and shared by FRC teams. The code   */ /* must be accompanied by the FIRST BSD license file in the root directory of */ /* the project.                                                               */ /*----------------------------------------------------------------------------*/
package frc.robot

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 *
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

object Constants {
    // Motor PWM Ports
    const val LEFT_MOTOR_1 = 0
    const val LEFT_MOTOR_2 = 1
    const val RIGHT_MOTOR_1 = 2
    const val RIGHT_MOTOR_2 = 3

    const val ARM_MOTOR = 4

    // Joystick Order Number
    const val JOYSTICK_1 = 0
    // Joystick Button Numbers
    const val RELEASE_ARM_BUTTON = 1
}
