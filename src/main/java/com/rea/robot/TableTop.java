package com.rea.robot;

/**
 * A table top object has fixed size: width and length, the robot should not fall off the table top
 * Created by wxu on 6/23/16.
 */
public class TableTop {
    private final int width;
    private final int length;

    public TableTop(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public boolean isInTableArea(Position position) {
        return position.getX() >= 0 && position.getX() < width
                && position.getY() >= 0 && position.getY() < length;
    }
}
