package com.rea.robot.domain;

/**
 * Position of the robot on table top, origin(0, 0) is the most SOUTH WEST corner
 * This is a immutable class, need to create a new object for a different position
 *
 * Created by wxu on 6/23/16.
 */
public class Position {
    public static final Position NULL_POSITION = new Position(null, null);

    /**
     * position in x-axis
     */
    private final Integer x;

    /**
     * position in y-axis
     */
    private final Integer y;

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
