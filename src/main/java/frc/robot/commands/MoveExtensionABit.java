// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class MoveExtensionABit extends CommandBase {
  /** Creates a new MoveExtensionABit. */
  Arm m_arm;
  private double extensionGoal;
  public MoveExtensionABit(Arm arm) {
    m_arm = arm;
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    extensionGoal = m_arm.getExtensionPosition() + .4;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_arm.getExtensionPosition() < extensionGoal) {
      m_arm.setExtensionMotor(.2);
    } else {
      m_arm.setExtensionMotor(-.2);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("cmplt cmnd :)");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (
      (m_arm.getExtensionPosition() < extensionGoal + 0.1) && 
      (m_arm.getExtensionPosition() > extensionGoal - 0.1) 
    );
  }
}
