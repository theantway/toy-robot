package com.rea.robot.command.impl;

import com.rea.robot.command.Command;
import com.rea.robot.domain.Position;
import com.rea.robot.domain.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Move the robot one step towards the current direction.
 * <p>
 * Created by wxu on 6/23/16.
 */
public class MoveCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(MoveCommand.class);

    public void execute(Robot robot) {
        Position newPosition = robot.getDirection().nextPosition(robot.getPosition());

        if (!robot.getTableTop().isInTableArea(newPosition)) {
            logger.debug("Ignored invalid position");
            return;
        }

        robot.setPosition(newPosition);
    }
}
