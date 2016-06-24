package com.rea.robot.command.impl;

import com.rea.robot.command.Command;
import com.rea.robot.domain.Direction;
import com.rea.robot.domain.Position;
import com.rea.robot.domain.Robot;

/**
 * This command place the robot to a specific position on the table top
 *
 * Created by wxu on 6/23/16.
 */
public class PlaceCommand implements Command {
    private final int x;
    private final int y;
    private final Direction direction;

    public PlaceCommand(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void execute(Robot robot) {
        robot.changePositionAndDirection(new Position(x, y), direction);
    }
}
