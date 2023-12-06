// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  CANSparkMax extensionMotor = new CANSparkMax(Constants.kExtensionMotorPort, MotorType.kBrushless);
  CANSparkMax rotationMotor = new CANSparkMax(Constants.kRotationMotorPort, MotorType.kBrushless);
  
  public Arm() {}

  public void setExtensionMotor (double volt) {
    extensionMotor.set(volt);
  }
  public void setRotationMotor (double volt) {
    extensionMotor.set(volt);
  }

  public double getExtensionPosition (){
    return extensionMotor.getEncoder().getPosition();
  }

  public double getRotationPosition (){
    return rotationMotor.getEncoder().getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
