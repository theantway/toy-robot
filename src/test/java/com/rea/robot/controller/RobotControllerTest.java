package com.rea.robot.controller;

import com.rea.robot.command.Command;
import com.rea.robot.command.impl.LeftCommand;
import com.rea.robot.command.impl.MoveCommand;
import com.rea.robot.command.impl.PlaceCommand;
import com.rea.robot.command.impl.RightCommand;
import com.rea.robot.domain.Direction;
import com.rea.robot.domain.Position;
import com.rea.robot.domain.Robot;
import com.rea.robot.reader.CommandReaderStub;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static com.rea.robot.builder.RobotBuilder.aRobot;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

@Test
public class RobotControllerTest {
    public void should_place_robot_to_tabletop() {
        RobotController robotController = controllerWithCommands(
                new PlaceCommand(0, 0, Direction.NORTH));

        Robot robot = robotController.executeCommands(aRobot().build());

        verifyPositionAndDirection(robot, 0, 0, Direction.NORTH);
    }

    public void should_able_to_move_after_placed_on_tabletop() {
        RobotController robotController = controllerWithCommands(
                new PlaceCommand(0, 0, Direction.NORTH),
                new MoveCommand());

        Robot robot = robotController.executeCommands(aRobot().build());

        verifyPositionAndDirection(robot, 0, 1, Direction.NORTH);
    }

    public void should_able_to_turn_left() {
        RobotController robotController = controllerWithCommands(
                new PlaceCommand(0, 0, Direction.NORTH),
                new LeftCommand());

        Robot robot = robotController.executeCommands(aRobot().build());

        verifyPositionAndDirection(robot, 0, 0, Direction.WEST);
    }

    public void should_able_to_turn_right() {
        RobotController robotController = controllerWithCommands(
                new PlaceCommand(0, 0, Direction.NORTH),
                new RightCommand());

        Robot robot = robotController.executeCommands(aRobot().build());

        verifyPositionAndDirection(robot, 0, 0, Direction.EAST);
    }

    public void should_ignore_commands_before_place_to_table() {
        RobotController robotController = controllerWithCommands(
                new MoveCommand(),
                new LeftCommand());

        Robot robot = robotController.executeCommands(aRobot().build());

        assertThat(robot.getPosition(), Is.is(Position.NULL_POSITION));
        assertThat(robot.getDirection(), nullValue());
    }

    public void should_prevent_fall_off_the_tabletop() {
        RobotController robotController = controllerWithCommands(new PlaceCommand(-1, 0, Direction.NORTH));

        Robot robot = robotController.executeCommands(aRobot().build());

        assertThat(robot.getPosition(), is(Position.NULL_POSITION));
    }

    public void should_continue_execute_following_commands_after_ignored_invalid_position() {
        RobotController robotController = controllerWithCommands(
                new PlaceCommand(-1, 0, Direction.NORTH),
                new PlaceCommand(0, 0, Direction.NORTH));

        Robot robot = robotController.executeCommands(aRobot().build());

        verifyPositionAndDirection(robot, 0, 0, Direction.NORTH);
    }

    private RobotController controllerWithCommands(Command... commands) {
        return new RobotController(new CommandReaderStub(commands));
    }

    private void verifyPositionAndDirection(Robot robot, int x, int y, Direction direction) {
        assertThat(robot.getDirection(), is(direction));
        assertReflectionEquals(robot.getPosition(), new Position(x, y));
    }
}
