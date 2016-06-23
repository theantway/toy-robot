package com.rea.robot.command;

import com.rea.robot.Direction;
import com.rea.robot.Position;
import com.rea.robot.Robot;

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
        robot.setPosition(new Position(x, y));
        robot.setDirection(direction);
    }
}
