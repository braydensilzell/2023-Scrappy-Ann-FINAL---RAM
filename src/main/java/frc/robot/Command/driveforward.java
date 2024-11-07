// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class driveforward extends CommandBase {
  /** Creates a new drivebackward. */
  Long endtimeLong;
  Double speed1;
  Long target1;
  public driveforward(Double speed, Long target) {
    addRequirements(Robot.drivetrain);
    this.speed1 = speed;
    this.target1 = target;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    endtimeLong = System.currentTimeMillis() + target1;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.drivetrain.setpower(-speed1, -speed1);
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
