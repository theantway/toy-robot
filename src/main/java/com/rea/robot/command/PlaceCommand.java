package com.rea.robot.command;

import com.rea.robot.domain.Direction;
import com.rea.robot.domain.Position;
import com.rea.robot.domain.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This command place the robot to a specific position on the table top
 *
 * Created by wxu on 6/23/16.
 */
public class PlaceCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(PlaceCommand.class);

    private final int x;
    private final int y;
    private final Direction direction;

    public PlaceCommand(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void execute(Robot robot) {
        Position position = new Position(x, y);

        if (!robot.getTableTop().isInTableArea(position))
        {
            logger.debug("Ignored invalid position");
            return;
        }

        robot.setPosition(position);
        robot.setDirection(direction);
    }
}
