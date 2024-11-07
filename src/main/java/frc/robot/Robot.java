// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.Command.Auto;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  
private final PS4Controller ps4 = new PS4Controller(0);
public static Drivetrain drivetrain;
  public static PS4Controller driver;
  //public static Elbow elbow;
  public static Auto auto;
  public static PS4Controller driver2;

  public static Compressor compressor;
  public static DoubleSolenoid grabber;
  public static DoubleSolenoid extend;
  public static DoubleSolenoid arm;
  public static RobotContainer robotcontainer;

  public static long target = 2200;
  public static long target1 = 1700;


  @Override
  public void robotInit() {
  drivetrain = new Drivetrain();
  driver = new PS4Controller(0);
  driver2 = new PS4Controller(1);
   auto = new Auto();  //AUTO
   
   compressor = new Compressor(2, PneumaticsModuleType.REVPH);           //COMPRESSOR

   extend = new DoubleSolenoid(2, PneumaticsModuleType.REVPH, 5, 7);  //SOLENOIDS
   grabber = new DoubleSolenoid(2, PneumaticsModuleType.REVPH, 14, 15);
   arm = new DoubleSolenoid(2, PneumaticsModuleType.REVPH, 0, 6);
   
   

   robotcontainer = new RobotContainer(); //ARM
  }

@Override
  public void robotPeriodic() {}

@Override
  public void autonomousInit() {
    auto.schedule();
  }

@Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }
  
  
@Override
  public void teleopInit() {

    compressor.enableAnalog(110,120);
    grabber.set(Value.kForward);
    grabber.set(Value.kReverse);

    extend.set(Value.kForward);
    extend.set(Value.kReverse);

    arm.set(Value.kForward);
    arm.set(Value.kReverse);
  }



  @Override
  public void teleopPeriodic() {
    
   double y = ps4.getR2Axis();  //DRIVETRAIN
   double x = ps4.getLeftY(); //DRIVETRAIN

   //double Move = ((x<0)?-1:1)*Math.sqrt(Math.abs(x));
   //double Steer = ((y<0)?-1:1)*Math.sqrt(Math.abs(y));

   double f = ps4.getR2Axis(); //ARM UP
   double b = ps4.getL2Axis(); //ARM DOWN
   
   boolean u = ps4.getL1Button();
   boolean d = ps4.getR1Button();
  
   drivetrain.setpower(x + y, x - y);
   robotcontainer.configurebuttons();
  }

}
