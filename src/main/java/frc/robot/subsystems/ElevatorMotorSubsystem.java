// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.robotMap;
import frc.robot.Constants;

public class ElevatorMotorSubsystem extends SubsystemBase {
  private CANSparkMax ElevatorMotor;
  private static DigitalInput UpMicroSwicth;
  private static DigitalInput DownMicroSwicth;

  public ElevatorMotorSubsystem() {
    ElevatorMotor = new CANSparkMax(robotMap.kElevatorMotorPort, MotorType.kBrushless);
    ElevatorMotor.setInverted(false);
    ElevatorMotor.setIdleMode(IdleMode.kBrake);
    ElevatorMotor.setSmartCurrentLimit(30);

    UpMicroSwicth = new DigitalInput(robotMap.kUpMicroSwitchPort);
    DownMicroSwicth = new DigitalInput(robotMap.kDownMicroSwitchPort);
  }

  public void setDesiredState(Boolean Direction) {
    ElevatorMotor.set((Direction ? (UpMicroSwicth.get() ? 0 : 1) : (DownMicroSwicth.get() ? 0 : -1)) * Constants.DriverConstants.kElevatorSpeed);
    SmartDashboard.putString("Direction", Direction ? "UP" : "DOWN");
  }

  public void stop() {
    ElevatorMotor.set(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("UpMicroSwitch", UpMicroSwicth.get());
    SmartDashboard.putBoolean("DownMicroSwitch", DownMicroSwicth.get());
  }
}
