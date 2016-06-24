package com.rea.robot.builder;


import com.rea.robot.domain.Direction;
import com.rea.robot.domain.Position;
import com.rea.robot.domain.Robot;
import com.rea.robot.domain.TableTop;

public class RobotBuilder {
    private Position position;
    private Direction direction;
    private TableTop tableTop;

    public static RobotBuilder aRobot() {
        return new RobotBuilder();
    }

    public RobotBuilder withPositionAndDirection(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
        return this;
    }

    public RobotBuilder withTableTop(TableTop tableTop) {
        this.tableTop = tableTop;
        return this;
    }

    public Robot build() {
        Robot robot = new Robot();

        if (tableTop == null) {
            robot.setTableTop(new TableTop(5, 5));
        } else {
            robot.setTableTop(tableTop);
        }

        if (position != null) {
            robot.changePositionAndDirection(position, direction);
        }

        return robot;
    }

}
