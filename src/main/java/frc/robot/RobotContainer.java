// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** Add your docs here. */
public class RobotContainer {
    JoystickButton buttonLT;
 public RobotContainer(){
   
 }
 
public void configurebuttons(){
//-----------------------------------------------------//GRABBER
     if (Robot.driver2.getCrossButton() == true) {

        Robot.grabber.set(Value.kForward);
     }  
     if (Robot.driver2.getCircleButton() == true) {

      Robot.grabber.set(Value.kReverse);
   }  

//-----------------------------------------------------//EXTEND

   if (Robot.driver2.getL1Button() == true) {

      Robot.extend.set(Value.kForward);
   }  
   if (Robot.driver2.getR1Button() == true) {

    Robot.extend.set(Value.kReverse);
 }  

//-----------------------------------------------------//ARM
 
 if (Robot.driver2.getTriangleButton() == true) {

   Robot.arm.set(Value.kReverse);
}  
if (Robot.driver2.getSquareButton() == true) {

 Robot.arm.set(Value.kForward);
 }  

   }

}
 