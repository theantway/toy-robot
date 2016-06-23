package com.rea.robot.command;

import com.rea.robot.Direction;
import com.rea.robot.Position;
import com.rea.robot.Robot;
import org.testng.annotations.Test;

import static com.rea.robot.builder.RobotBuilder.aRobot;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class LeftCommandTest {
    public void should_execute_command() {
        Position position = new Position(0, 0);
        Robot robot = aRobot().withPosition(position).withDirection(Direction.EAST).build();

        new LeftCommand().execute(robot);

        assertThat(robot.getPosition(), is(position));
        assertThat(robot.getDirection(), is(Direction.NORTH));
    }
}