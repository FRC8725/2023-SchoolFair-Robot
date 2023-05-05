package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorMotorSubsystem;

public class ElevatorButtonCmd extends CommandBase {
  private final ElevatorMotorSubsystem ElevatorSubsystem;
  private final Boolean Direction;

  public ElevatorButtonCmd(ElevatorMotorSubsystem subsystem, Boolean direction) {

    ElevatorSubsystem = subsystem;
    this.Direction = direction;
        
    addRequirements(ElevatorSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    ElevatorSubsystem.setDesiredState(this.Direction);
  }

  @Override
  public void end(boolean interrupted) {
   ElevatorSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}