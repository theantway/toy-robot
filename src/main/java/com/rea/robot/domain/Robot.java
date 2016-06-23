package com.rea.robot.domain;

/**
 * The Robot class can be placed to a specific position on a table top, then execute commands.
 * The Robot SHOULD NOT fall off the table top
 *
 * Created by wxu on 6/23/16.
 */
public class Robot {
    private Position position = Position.NULL_POSITION;
    private Direction direction;
    private TableTop tableTop;

    public Position getPosition() {
        return position;
    }

    /**
     * The Robot <b>SHOULD NOT</b> fall off the table top,
     * caller of this method need to ensure the position is valid by tableTop.
     *
     * @param position new robot position, throws IllegalArgumentException if position not inside the tabletop
     */
    public void setPosition(Position position) {
        if (tableTop == null) {
            throw new RuntimeException("Robot not associated with a tabletop");
        }

        if (!tableTop.isInTableArea(position)) {
            throw new IllegalArgumentException("New position is outside the table top");
        }

        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setTableTop(TableTop tableTop) {
        this.tableTop = tableTop;
    }

    public TableTop getTableTop() {
        return tableTop;
    }
}
