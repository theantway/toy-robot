package com.rea.robot.command.impl;

import com.rea.robot.command.Command;
import com.rea.robot.domain.Robot;

/**
 * Control the robot to turn right, the position keeps unchanged
 *
 * Created by wxu on 6/23/16.
 */
public class RightCommand implements Command {
    @Override
    public void execute(Robot robot) {
        robot.changePositionAndDirection(robot.getPosition(), robot.getDirection().right());
    }
}
