package com.rea.robot.command;

import com.rea.robot.Direction;
import com.rea.robot.Position;
import com.rea.robot.Robot;
import com.rea.robot.TableTop;
import org.testng.annotations.Test;

import static com.rea.robot.builder.RobotBuilder.aRobot;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

@Test
public class PlaceCommandTest {
    public void should_place_robot_on_table() {
        Robot robot = aRobot().withTableTop(new TableTop(5, 5)).build();

        new PlaceCommand(0, 0, Direction.NORTH).execute(robot);

        assertThat(robot.getPosition(), is(new Position(0, 0)));
        assertThat(robot.getDirection(), is(Direction.NORTH));
    }

    public void should_prevent_robot_fall_off_table() {
        Robot robot = aRobot().build();

        new PlaceCommand(-1, 0, Direction.NORTH).execute(robot);

        assertThat(robot.getPosition(), is(Position.NullPosition));
        assertThat(robot.getDirection(), nullValue());
    }
}