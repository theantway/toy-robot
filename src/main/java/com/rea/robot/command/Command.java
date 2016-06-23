package com.rea.robot.command;

import com.rea.robot.Robot;

/**
 * All robot supported commands should implement this interface
 * The concrete implementation changes status of the robot
 *
 * Created by wxu on 6/23/16.
 */
public interface Command {
    void execute(Robot robot);
}
