package com.rea.robot.controller;

import com.rea.robot.command.Command;
import com.rea.robot.command.impl.PlaceCommand;
import com.rea.robot.command.impl.PowerOffCommand;
import com.rea.robot.domain.Position;
import com.rea.robot.domain.Robot;
import com.rea.robot.reader.CommandReader;

/**
 * Read commands and execute on robot
 * Created by wxu on 6/23/16.
 */
public class RobotController {
    private final CommandReader commandReader;

    public RobotController(CommandReader commandReader) {
        this.commandReader = commandReader;
    }

    public Robot executeCommands(Robot robot) {
        while(true) {
            Command command = commandReader.nextCommand();

            if (command instanceof PowerOffCommand) {
                break;
            }

            if (robot.getPosition() == Position.NULL_POSITION && !(command instanceof PlaceCommand)) {
                continue;
            }

            command.execute(robot);
        }

        return robot;
    }
}
