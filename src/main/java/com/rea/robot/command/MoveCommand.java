package com.rea.robot.command;

import com.rea.robot.Direction;
import com.rea.robot.Position;
import com.rea.robot.Robot;

/**
 * Move the robot one step towards the current direction.
 *
 * Created by wxu on 6/23/16.
 */
public class MoveCommand implements Command {
    public void execute(Robot robot) {
        Position newPosition = nextPosition(robot.getDirection(), robot.getPosition());
        robot.setPosition(newPosition);
    }

    private Position nextPosition(Direction direction, Position position) {
        switch (direction) {
            case NORTH:
                return new Position(position.getX(), position.getY() + 1);
            case EAST:
                return new Position(position.getX() + 1, position.getY());
            case SOUTH:
                return new Position(position.getX(), position.getY() - 1);
            case WEST:
                return new Position(position.getX() - 1, position.getY());
            default:
                throw new IllegalStateException("Invalid direction");
        }
    }
}
