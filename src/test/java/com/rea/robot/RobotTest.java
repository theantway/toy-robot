package com.rea.robot;

import com.rea.robot.command.LeftCommand;
import com.rea.robot.command.MoveCommand;
import com.rea.robot.command.PlaceCommand;
import com.rea.robot.command.RightCommand;
import com.rea.robot.reader.CommandReaderStub;
import org.testng.annotations.Test;

import static com.rea.robot.builder.RobotBuilder.aRobot;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class RobotTest {
    public void should_place_robot_to_tabletop() {
        Robot robot = aRobot().build();

        robot.executeCommand(new PlaceCommand(0, 0, Direction.NORTH));

        verifyPositionAndDirection(robot, 0, 0, Direction.NORTH);
    }

    public void should_able_to_move_after_placed_on_tabletop() {
        Robot robot = aRobot().build();

        robot.executeCommand(new PlaceCommand(0, 0, Direction.NORTH));
        robot.executeCommand(new MoveCommand());

        verifyPositionAndDirection(robot, 0, 1, Direction.NORTH);
    }

    public void should_able_to_turn_left() {
        Robot robot = aRobot().build();

        robot.executeCommand(new PlaceCommand(0, 0, Direction.NORTH));
        robot.executeCommand(new LeftCommand());

        verifyPositionAndDirection(robot, 0, 0, Direction.WEST);
    }

    public void should_able_to_turn_right() {
        Robot robot = aRobot().build();

        robot.executeCommand(new PlaceCommand(0, 0, Direction.NORTH));
        robot.executeCommand(new RightCommand());

        verifyPositionAndDirection(robot, 0, 0, Direction.EAST);
    }

    public void should_able_to_execute_commands() {
        Robot robot = aRobot().withCommandReader(new CommandReaderStub(
                new PlaceCommand(0, 0, Direction.NORTH),
                new RightCommand())).build();

        robot.executeCommands();

        verifyPositionAndDirection(robot, 0, 0, Direction.EAST);
    }

    public void should_prevent_fall_off_the_tabletop() {
        Robot robot = aRobot().withTableTop(new TableTop(5, 5)).build();

        robot.executeCommand(new PlaceCommand(-1, 0, Direction.NORTH));

        assertThat(robot.getPosition(), is(Position.NullPosition));
    }

    public void should_continue_execute_following_commands_after_ignored_invalid_position() {
        Robot robot = aRobot().withTableTop(new TableTop(5, 5)).build();

        robot.executeCommand(new PlaceCommand(-1, 0, Direction.NORTH));
        robot.executeCommand(new PlaceCommand(0, 0, Direction.NORTH));

        verifyPositionAndDirection(robot, 0, 0, Direction.NORTH);
    }

    private void verifyPositionAndDirection(Robot robot, int x, int y, Direction direction) {
        assertThat(robot.getPosition(), is(new Position(x, y)));
        assertThat(robot.getDirection(), is(direction));
    }
}
