package com.rea.robot.domain;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

@Test
public class RobotTest {
    public void should_throw_exception_when_set_position_without_a_tabletop() {
        try {
            new Robot().changePositionAndDirection(new Position(1, 1), Direction.NORTH);
            fail("should throw exception");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage(), containsString("Robot not associated with a tabletop"));
        }
    }

    public void should_throw_exception_direction_is_null() {
        try {
            Robot robot = new Robot();
            robot.setTableTop(new TableTop(5, 5));
            robot.changePositionAndDirection(new Position(1, 1), null);
            fail("should throw exception if direction is null");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Direction should not be null"));
        }
    }

    public void should_ignore_when_set_position_outside_tabletop() {
        Robot robot = new Robot();
        robot.setTableTop(new TableTop(5, 5));
        Position unsafePosition = new Position(-1, 1);

        robot.changePositionAndDirection(unsafePosition, Direction.NORTH);
        assertFalse(robot.isPlacedOnTable());
    }

    public void should_return_if_placed_on_table_not() {
        Robot robot = new Robot();
        Assert.assertFalse(robot.isPlacedOnTable(), "by default not on table");

        robot.setTableTop(new TableTop(5, 5));
        robot.changePositionAndDirection(new Position(0, 0), Direction.NORTH);

        Assert.assertTrue(robot.isPlacedOnTable(), "on table after set position");
    }
}