package frc.robot

import edu.wpi.first.wpilibj.Joystick

@Mockable
class OI (private val joystick: Joystick) {
    fun getFwd (): Double {
        // forward is negative, backward is positive for some reason
        return -joystick.y
    }
    fun getRot (): Double {
        return joystick.x
    }

    fun getSlider (): Double {
        // forward is negative, backward is positive for some reason
        return -joystick.throttle
    }
}