package com.rea.robot.command.impl;

import com.rea.robot.command.Command;
import com.rea.robot.domain.Direction;
import com.rea.robot.domain.Position;
import com.rea.robot.domain.Robot;

/**
 * Move the robot one step towards the current direction.
 * <p>
 * Created by wxu on 6/23/16.
 */
public class MoveCommand implements Command {

    public void execute(Robot robot) {
        Position position = robot.getPosition();
        Direction direction = robot.getDirection();

        Position newPosition = direction.nextPosition(position);
        robot.changePositionAndDirection(newPosition, direction);
    }
}
