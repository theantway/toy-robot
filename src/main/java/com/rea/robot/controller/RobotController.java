package com.rea.robot.controller;

import com.rea.robot.command.Command;
import com.rea.robot.command.impl.PlaceCommand;
import com.rea.robot.command.impl.PowerOffCommand;
import com.rea.robot.domain.Robot;
import com.rea.robot.reader.CommandReader;

/**
 * Read commands and execute on robot. This class kind of like the heart of the robot, receive commands and execute them.
 * Created by wxu on 6/23/16.
 */
public class RobotController {
    private final CommandReader commandReader;

    public RobotController(CommandReader commandReader) {
        this.commandReader = commandReader;
    }

    /**
     * execute commands read from commandReader until read a POWEROFF command or there's no more Command available.
     * @param robot the robot to control
     * @return robot with updated status
     */
    public Robot executeCommands(Robot robot) {
        while(true) {
            Command command = commandReader.nextCommand();

            if (command instanceof PowerOffCommand) {
                break;
            }

            if (!robot.isPlacedOnTable() && !(command instanceof PlaceCommand)) {
                continue;
            }

            command.execute(robot);
        }

        return robot;
    }
}
