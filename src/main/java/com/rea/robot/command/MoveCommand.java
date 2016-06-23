package com.rea.robot.command;

import com.rea.robot.domain.Direction;
import com.rea.robot.domain.Position;
import com.rea.robot.domain.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Move the robot one step towards the current direction.
 *
 * Created by wxu on 6/23/16.
 */
public class MoveCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(MoveCommand.class);

    public void execute(Robot robot) {
        Position newPosition = nextPosition(robot.getDirection(), robot.getPosition());

        if (!robot.getTableTop().isInTableArea(newPosition))
        {
            logger.debug("Ignored invalid position");
            return;
        }

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
