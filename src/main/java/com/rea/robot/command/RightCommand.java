package com.rea.robot.command;

import com.rea.robot.domain.Robot;

/**
 * Control the robot to turn right, the position keeps unchanged
 *
 * Created by wxu on 6/23/16.
 */
public class RightCommand implements Command{
    @Override
    public void execute(Robot robot) {
        robot.setDirection(robot.getDirection().right());
    }
}
