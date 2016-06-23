package com.rea.robot.domain;

/**
 * Direction class which knows its left, right and next position for specified position
 * Created by wxu on 6/23/16.
 */
public enum Direction {
    NORTH {
        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        public Direction right() {
            return EAST;
        }

        @Override
        public Position nextPosition(Position position) {
            return new Position(position.getX(), position.getY() + 1);
        }
    },
    EAST {
        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        public Direction right() {
            return SOUTH;
        }

        @Override
        public Position nextPosition(Position position) {
            return new Position(position.getX() + 1, position.getY());
        }
    },
    SOUTH {
        @Override
        public Direction left() {
            return EAST;
        }

        @Override
        public Direction right() {
            return WEST;
        }

        @Override
        public Position nextPosition(Position position) {
            return new Position(position.getX(), position.getY() - 1);
        }
    },
    WEST {
        @Override
        public Direction left() {
            return SOUTH;
        }

        @Override
        public Direction right() {
            return NORTH;
        }

        @Override
        public Position nextPosition(Position position) {
            return new Position(position.getX() - 1, position.getY());
        }
    };

    /**
     * @return the left Direction of the current
     */
    public abstract Direction left();

    /**
     * @return the right Direction of the current
     */
    public abstract Direction right();

    /**
     * return the next position based on current position and direction
     * @param position current position
     * @return the next position
     */
    public abstract Position nextPosition(Position position);
}
