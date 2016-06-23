package com.rea.robot.command;

import com.rea.robot.Direction;
import com.rea.robot.Position;
import com.rea.robot.Robot;
import com.rea.robot.TableTop;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.rea.robot.builder.RobotBuilder.aRobot;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
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
        Robot robot = aRobot()
                .withPosition(new Position(x, y))
                .withDirection(direction).build();

        new MoveCommand().execute(robot);

        assertThat(robot.getPosition(), is(new Position(newX, newY)));
        assertThat(robot.getDirection(), is(direction));
    }

    public void should_prevent_fall_off_table() {
        Position originalPosition = new Position(4, 4);
        Robot robot = aRobot().withTableTop(new TableTop(5, 5))
                .withPosition(originalPosition)
                .withDirection(Direction.NORTH).build();

        new MoveCommand().execute(robot);

        assertThat(robot.getPosition(), is(originalPosition));
    }
}