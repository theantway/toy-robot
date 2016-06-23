package com.rea.robot.domain;

import com.rea.robot.command.LeftCommand;
import com.rea.robot.command.MoveCommand;
import com.rea.robot.command.PlaceCommand;
import com.rea.robot.command.RightCommand;
import com.rea.robot.reader.CommandReaderStub;
import org.testng.annotations.Test;

import static com.rea.robot.builder.RobotBuilder.aRobot;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

@Test
public class RobotTest {
    public void should_place_robot_to_tabletop() {
        Robot robot = aRobot().withCommandReader(new CommandReaderStub(
                new PlaceCommand(0, 0, Direction.NORTH))).build();

        robot.executeCommands();

        verifyPositionAndDirection(robot, 0, 0, Direction.NORTH);
    }

    public void should_able_to_move_after_placed_on_tabletop() {
        Robot robot = aRobot().withCommandReader(new CommandReaderStub(
                new PlaceCommand(0, 0, Direction.NORTH),
                new MoveCommand())).build();

        robot.executeCommands();

        verifyPositionAndDirection(robot, 0, 1, Direction.NORTH);
    }

    public void should_able_to_turn_left() {
        Robot robot = aRobot().withCommandReader(new CommandReaderStub(
                new PlaceCommand(0, 0, Direction.NORTH),
                new LeftCommand())).build();

        robot.executeCommands();

        verifyPositionAndDirection(robot, 0, 0, Direction.WEST);
    }

    public void should_able_to_turn_right() {
        Robot robot = aRobot().withCommandReader(new CommandReaderStub(
                new PlaceCommand(0, 0, Direction.NORTH),
                new RightCommand())).build();

        robot.executeCommands();

        verifyPositionAndDirection(robot, 0, 0, Direction.EAST);
    }

    public void should_ignore_commands_before_place_to_table() {
        Robot robot = aRobot().withCommandReader(new CommandReaderStub(
                new MoveCommand(),
                new LeftCommand())).build();

        robot.executeCommands();

        assertThat(robot.getPosition(), is(Position.NULL_POSITION));
        assertThat(robot.getDirection(), nullValue());
    }

    public void should_prevent_fall_off_the_tabletop() {
        Robot robot = aRobot().withCommandReader(new CommandReaderStub(
                new PlaceCommand(-1, 0, Direction.NORTH))).build();

        robot.executeCommands();

        assertThat(robot.getPosition(), is(Position.NULL_POSITION));
    }

    public void should_continue_execute_following_commands_after_ignored_invalid_position() {
        Robot robot = aRobot().withCommandReader(new CommandReaderStub(
                new PlaceCommand(-1, 0, Direction.NORTH),
                new PlaceCommand(0, 0, Direction.NORTH))).build();

        robot.executeCommands();

        verifyPositionAndDirection(robot, 0, 0, Direction.NORTH);
    }

    private void verifyPositionAndDirection(Robot robot, int x, int y, Direction direction) {
        assertThat(robot.getDirection(), is(direction));
        assertReflectionEquals(robot.getPosition(), new Position(x, y));
    }
}
