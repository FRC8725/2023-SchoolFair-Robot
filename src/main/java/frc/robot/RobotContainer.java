// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ElevatorButtonCmd;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveJoystickCmd;
import frc.robot.subsystems.DirveMotorSubsystem;
import frc.robot.subsystems.ElevatorMotorSubsystem;



public class RobotContainer {

  private final DirveMotorSubsystem DriverSubsystem = new DirveMotorSubsystem();
  private final ElevatorMotorSubsystem ElevatorSubsystem = new ElevatorMotorSubsystem();
  private final GamepadJoystick driverJoystick = new GamepadJoystick(GamepadJoystick.kDriverControllerPort);


  public RobotContainer() {
    // Configure the trigger bindings
    DriverSubsystem.setDefaultCommand(new DriveJoystickCmd(DriverSubsystem, 
    () -> -driverJoystick.getRawAxis(GamepadJoystick.kDriverYAxis), 
    () -> driverJoystick.getRawAxis(GamepadJoystick.kDriverXAxis)));

    configureBindings();
  }

  private void configureBindings() {
    driverJoystick.btn_y.whileTrue(new ElevatorButtonCmd(ElevatorSubsystem,true));
    driverJoystick.btn_a.whileTrue(new ElevatorButtonCmd(ElevatorSubsystem,false));
  }

  public Command getAutonomousCommand() {
    // Autos.exampleAuto(m_exampleSubsystem);
    return null;
  }
}
