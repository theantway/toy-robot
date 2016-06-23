package com.rea.robot;

import com.rea.robot.command.MoveCommand;
import com.rea.robot.command.PlaceCommand;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class RobotTest {
    public void should_place_robot_to_tabletop() {
        Robot robot = new Robot();

        robot.executeCommand(new PlaceCommand(0, 0, Direction.NORTH));

        verifyPositionAndDirection(robot, 0, 0, Direction.NORTH);
    }

    public void should_able_to_move_after_placed_on_tabletop() {
        Robot robot = new Robot();

        robot.executeCommand(new PlaceCommand(0, 0, Direction.NORTH));
        robot.executeCommand(new MoveCommand());

        verifyPositionAndDirection(robot, 0, 1, Direction.NORTH);
    }

    private void verifyPositionAndDirection(Robot robot, int x, int y, Direction direction) {
        assertThat(robot.getPosition().getX(), is(x));
        assertThat(robot.getPosition().getY(), is(y));
        assertThat(robot.getDirection(), is(direction));
    }
}
