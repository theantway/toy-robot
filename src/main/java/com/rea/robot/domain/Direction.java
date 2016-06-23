package com.rea.robot.domain;

/**
 * Directions
 * Created by wxu on 6/23/16.
 */
public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction left() {
        switch (this) {
            case NORTH: return WEST;
            case EAST: return NORTH;
            case SOUTH: return EAST;
            case WEST: return SOUTH;
            default:
                throw new IllegalStateException("missed left direction for " + this.name());
        }
    }

    public Direction right() {
        switch (this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default:
                throw new IllegalStateException("missed right direction for " + this.name());
        }
    }
}
