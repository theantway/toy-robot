package com.rea.robot;

import com.rea.robot.domain.Direction;
import com.rea.robot.domain.Position;
import com.rea.robot.domain.Robot;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.io.StringReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class ApplicationTest {
    public void should_execute_move_commands() {
        String commands = StringUtils.join(new String[]{"PLACE 0,0,NORTH",
                "MOVE",
                "REPORT"
        }, "\n");

        Robot robot = Application.play(new StringReader(commands));

        verifyPositionAndDirection(robot, 0, 1, Direction.NORTH);
    }

    public void should_execute_direction_commands() {
        String commands = StringUtils.join(new String[]{"PLACE 0,0,NORTH",
                "LEFT",
                "REPORT"}, "\n");

        Robot robot = Application.play(new StringReader(commands));

        verifyPositionAndDirection(robot, 0, 0, Direction.WEST);
    }

    public void should_execute_combined_commands() {
        String commands = StringUtils.join(new String[]{"PLACE 1,2,EAST",
                "MOVE",
                "MOVE",
                "LEFT",
                "MOVE",
                "REPORT"}, "\n");

        Robot robot = Application.play(new StringReader(commands));

        verifyPositionAndDirection(robot, 3, 3, Direction.NORTH);
    }

    private void verifyPositionAndDirection(Robot robot, int x, int y, Direction direction) {
        Position position = robot.getPosition();

        assertThat(position.getX(), is(x));
        assertThat(position.getY(), is(y));
        assertThat(robot.getDirection(), is(direction));
    }
}