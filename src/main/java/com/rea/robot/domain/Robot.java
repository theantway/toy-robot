package com.rea.robot.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Robot class can be placed to a specific position on a table top, then execute commands.
 * The Robot SHOULD NOT fall off the table top
 *
 * Created by wxu on 6/23/16.
 */
public class Robot {
    private static final Logger logger = LoggerFactory.getLogger(Robot.class);

    private Position position = Position.NULL_POSITION;
    private Direction direction;
    private TableTop tableTop;

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setTableTop(TableTop tableTop) {
        this.tableTop = tableTop;
    }

    /**
     * @return true if the robot had been placed on table, else false
     */
    public boolean isPlacedOnTable() {
        return position != Position.NULL_POSITION;
    }

    /**
     * The Robot <b>SHOULD NOT</b> fall off the table top,
     * caller of this method need to ensure the position is valid by tableTop.
     *
     * @param position new robot position, ignored if the new position is out of the tabletop's area
     * @param direction new direction
     */
    public void changePositionAndDirection(Position position, Direction direction) {
        if (tableTop == null) {
            throw new IllegalStateException("Robot not associated with a tabletop");
        }

        if (direction == null) {
            throw new IllegalArgumentException("Direction should not be null");
        }

        if (!tableTop.isInTableArea(position))
        {
            logger.debug("Ignored unsafe position");
            return;
        }

        this.position = position;
        this.direction = direction;
    }
}
