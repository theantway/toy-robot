package com.rea.robot;

import com.rea.robot.command.Command;


/**
 * The Robot class can be placed to a specific position on a table top, then execute commands.
 * The Robot SHOULD NOT fall off the table top
 *
 * Created by wxu on 6/23/16.
 */
public class Robot {
    private Position position;
    private Direction direction;

    public void executeCommand(Command command) {
        command.execute(this);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
