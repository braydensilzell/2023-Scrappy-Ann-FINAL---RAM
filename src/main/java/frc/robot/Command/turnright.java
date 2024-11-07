// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class turnright extends CommandBase {
  /** Creates a new drivebackward. */
  Long endtimeLong;
  Double speedright;
  Long targetright;
  public turnright(Double speed, Long target) {
    addRequirements(Robot.drivetrain);
    this.speedright = speed;
    this.targetright = target;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    endtimeLong = System.currentTimeMillis() + targetright;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.drivetrain.setpower(-speedright, speedright);
    System.out.println("high");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.drivetrain.setpower(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (endtimeLong < System.currentTimeMillis()){
      return true;
    }
    return false;
  }
}
