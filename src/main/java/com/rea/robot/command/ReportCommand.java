package com.rea.robot.command;

import com.rea.robot.Direction;
import com.rea.robot.Position;
import com.rea.robot.Robot;

public class ReportCommand implements Command{
    public void execute(Robot robot) {
        Position position = robot.getPosition();

        System.out.println(positionAndDirection(position, robot.getDirection()));
    }

    protected String positionAndDirection(Position position, Direction direction) {
        return position.getX() + ", " + position.getY() + ", " + direction;
    }
}