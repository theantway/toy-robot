package com.rea.robot.domain;

/**
 * Position of the robot on table top, origin(0, 0) is the most SOUTH WEST corner
 * This is a immutable class, need to create a new object for a different position
 *
 * Created by wxu on 6/23/16.
 */
public class Position {
    public static final Position NULL_POSITION = new Position(null, null);

    private final Integer x;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != null ? !x.equals(position.x) : position.x != null) return false;
        return y != null ? y.equals(position.y) : position.y == null;
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
