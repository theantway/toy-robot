package com.rea.robot.command;

import com.rea.robot.Direction;
import com.rea.robot.Position;
import com.rea.robot.Robot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by wxu on 6/23/16.
 */
public class MoveCommandTest {
    @DataProvider(name = "positions")
    public Object[][] positions() {
        return new Object[][]{
                new Object[]{2, 2, Direction.NORTH, 2, 3},
                new Object[]{2, 2, Direction.EAST, 3, 2},
                new Object[]{2, 2, Direction.SOUTH, 2, 1},
                new Object[]{2, 2, Direction.WEST, 1, 2},
        };
    }

    @Test(dataProvider = "positions")
    public void should_execute_command(int x, int y, Direction direction, int newX, int newY) {
        Robot robot = new Robot();
        robot.setPosition(new Position(x, y));
        robot.setDirection(direction);

        new MoveCommand().execute(robot);

        Position newPosition = robot.getPosition();
        assertThat(newPosition.getX(), is(newX));
        assertThat(newPosition.getY(), is(newY));
        assertThat(robot.getDirection(), is(direction));
    }
}