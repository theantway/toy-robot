package com.rea.robot.command.impl;

import com.rea.robot.command.Command;
import com.rea.robot.domain.Direction;
import com.rea.robot.domain.Position;
import com.rea.robot.domain.Robot;

/**
 * Report current position and direction to console
 */
public class ReportCommand implements Command {
    public void execute(Robot robot) {
        Position position = robot.getPosition();

        System.out.println(positionAndDirection(position, robot.getDirection()));
    }

    private String positionAndDirection(Position position, Direction direction) {
        return position.getX() + ", " + position.getY() + ", " + direction;
    }
}