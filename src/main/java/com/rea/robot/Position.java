package com.rea.robot;

/**
 * Position of the robot on table top, origin(0, 0) is the most SOUTH WEST corner
 * This is a immutable class, need to create a new object for a different position
 *
 * Created by wxu on 6/23/16.
 */
public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
