// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private final TalonFX m_rearrightMotor2 = new TalonFX(56);
  private final TalonFX m_midrightMotor = new TalonFX(57);  //R
  private final TalonFX m_frontrightMotor1 = new TalonFX(53);
  private final TalonFX m_rearleftMotor2 = new TalonFX(54);
  private final TalonFX m_midleftMotor = new TalonFX(50);  //L
  private final TalonFX m_frontleftMotor1 = new TalonFX(51);
  

  public Drivetrain() {
    m_rearrightMotor2.setInverted(true);
    m_midrightMotor.setInverted(true);  //R
    m_frontrightMotor1.setInverted(true);
    m_rearleftMotor2.setInverted(false);
    m_midleftMotor.setInverted(false);  //L
    m_frontleftMotor1.setInverted(false);
  }
   public void leftpower(double power){
     m_frontleftMotor1.set(ControlMode.PercentOutput, power);
     m_frontleftMotor1.set(ControlMode.PercentOutput, power);
     m_rearleftMotor2.set(ControlMode.PercentOutput, power);
     m_rearleftMotor2.set(ControlMode.PercentOutput, power);
     m_midleftMotor.set(ControlMode.PercentOutput, power);
   }
   public void rightpower(double power){
     m_frontrightMotor1.set(ControlMode.PercentOutput, power);
     m_frontrightMotor1.set(ControlMode.PercentOutput, power);
     m_rearrightMotor2.set(ControlMode.PercentOutput, power);
     m_rearrightMotor2.set(ControlMode.PercentOutput, power);
     m_midrightMotor.set(ControlMode.PercentOutput, power);
   }
   
   public void setpower(double left, double right){
     leftpower(left);
     rightpower(right);
   }  

 {
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
