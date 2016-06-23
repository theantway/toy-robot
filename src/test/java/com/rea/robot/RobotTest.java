package com.rea.robot;

import com.rea.robot.command.PlaceCommand;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class RobotTest {
    public void should_place_robot_to_tabletop() {
        Robot robot = new Robot();

        robot.executeCommand(new PlaceCommand(0, 0, Direction.NORTH));

        assertThat(robot.getPosition().getX(), is(0));
        assertThat(robot.getPosition().getY(), is(0));
        assertThat(robot.getDirection(), is(Direction.NORTH));
    }
}
