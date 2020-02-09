package frc.robot

import edu.wpi.first.wpilibj.Joystick

@Mockable
class OI(private val joystick: Joystick){
    fun getFwd (): Double {
        return joystick.y
    }
    fun getRot (): Double {
        return joystick.x
    }

    fun getSlider(): Double {
        return -joystick.throttle
    }
}