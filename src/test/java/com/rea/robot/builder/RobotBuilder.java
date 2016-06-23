package com.rea.robot.builder;


import com.rea.robot.Direction;
import com.rea.robot.Position;
import com.rea.robot.Robot;
import com.rea.robot.TableTop;
import com.rea.robot.reader.CommandReader;

public class RobotBuilder {
    private Position position;
    private Direction direction;
    private TableTop tableTop;
    private CommandReader commandReader;

    public static RobotBuilder aRobot() {
        return new RobotBuilder();
    }

    public RobotBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public RobotBuilder withTableTop(TableTop tableTop) {
        this.tableTop = tableTop;
        return this;
    }

    public RobotBuilder withDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public RobotBuilder withCommandReader(CommandReader commandReader) {
        this.commandReader = commandReader;
        return this;
    }

    public Robot build() {
        Robot robot = new Robot();

        if (commandReader != null) {
            robot.setCommandReader(commandReader);
        }

        if (tableTop == null) {
            robot.setTableTop(new TableTop(5, 5));
        } else {
            robot.setTableTop(tableTop);
        }

        if (position != null) {
            robot.setPosition(position);
        }

        if (direction != null) {
            robot.setDirection(direction);
        }

        return robot;
    }

}
