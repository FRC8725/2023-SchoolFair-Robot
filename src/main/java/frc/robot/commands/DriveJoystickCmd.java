package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DirveMotorSubsystem;

public class DriveJoystickCmd extends CommandBase {
  private final DirveMotorSubsystem MotorSubsystem;
  private final Supplier<Double> SpeedFunction, TurnFunction;

  public DriveJoystickCmd(DirveMotorSubsystem subsystem, Supplier<Double> SpeedFunction, Supplier<Double> TurnFunction) {
    MotorSubsystem = subsystem;
    this.SpeedFunction = SpeedFunction;
    this.TurnFunction = TurnFunction;

    this.addRequirements(MotorSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double Speed = SpeedFunction.get();
    double Turn = TurnFunction.get() * 0.6;

    SmartDashboard.putNumber("Speed", Speed);
    SmartDashboard.putNumber("Turn", Turn);

    double leftSpeed = Speed - Turn;
    double rightSpeed = Speed + Turn;

    MotorSubsystem.move(rightSpeed, leftSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    MotorSubsystem.stopModules();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
