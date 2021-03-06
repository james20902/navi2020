package org.usfirst.frc.team449.robot.subsystem.interfaces.position.commands;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.jetbrains.annotations.NotNull;
import org.usfirst.frc.team449.robot.other.Logger;
import org.usfirst.frc.team449.robot.subsystem.interfaces.position.SubsystemPosition;

/**
 * Set the velocity for a SubsystemPosition.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class SetSubsystemPositionVelocity extends InstantCommand {

    /**
     * The subsystem to execute this command on.
     */
    @NotNull
    private final SubsystemPosition subsystem;

    /**
     * The setpoint to run the motor at.
     */
    private final double setpoint;

    /**
     * Default constructor
     *
     * @param subsystem The subsystem to execute this command on.
     * @param setpoint  The setpoint to run the motor at.
     */
    @JsonCreator
    public SetSubsystemPositionVelocity(@NotNull @JsonProperty(required = true) SubsystemPosition subsystem,
                                        @JsonProperty(required = true) double setpoint) {
        this.subsystem = subsystem;
        this.setpoint = setpoint;
    }

    /**
     * Log when this command is initialized
     */
    @Override
    protected void initialize() {
        Logger.addEvent("SetSubsystemPositionVelocity init.", this.getClass());
    }

    /**
     * Set the setpoint.
     */
    @Override
    protected void execute() {
        subsystem.setMotorOutput(setpoint);
    }

    /**
     * Log when this command ends
     */
    @Override
    protected void end() {
        Logger.addEvent("SetSubsystemPositionVelocity end.", this.getClass());
    }

    /**
     * Log when this command is interrupted.
     */
    @Override
    protected void interrupted() {
        Logger.addEvent("SetSubsystemPositionVelocity Interrupted!", this.getClass());
    }
}
