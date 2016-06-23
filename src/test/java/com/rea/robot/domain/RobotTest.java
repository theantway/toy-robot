package com.rea.robot.domain;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

@Test
public class RobotTest {
    public void should_throw_exception_when_set_position_without_tabletop() {
        try {
            new Robot().setPosition(new Position(1, 1));
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), containsString("Robot not associated with a tabletop"));
        }
    }

    public void should_throw_exception_when_set_position_outside_tabletop() {
        try {
            Robot robot = new Robot();
            robot.setTableTop(new TableTop(5, 5));
            robot.setPosition(new Position(-1, 1));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("New position is outside the table top"));
        }
    }

    public void should_return_if_placed_on_table_not() {
        try {
            Robot robot = new Robot();
            Assert.assertFalse(robot.isPlacedOnTable(), "by default not on table");

            robot.setTableTop(new TableTop(5, 5));
            robot.setPosition(new Position(0, 0));
            Assert.assertTrue(robot.isPlacedOnTable(), "on table after set position");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("New position is outside the table top"));
        }
    }
}