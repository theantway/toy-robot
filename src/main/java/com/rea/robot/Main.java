package com.rea.robot;

import com.rea.robot.controller.RobotController;
import com.rea.robot.domain.Robot;
import com.rea.robot.domain.TableTop;
import com.rea.robot.reader.CommandReader;
import com.rea.robot.reader.CommandReaderImpl;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * The main class to run toy-robot
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Toy Robot's world, please input commands to control the robot.");
        play(new InputStreamReader(System.in, Charset.forName("utf-8")));
    }

    /**
     * setup and run robot by reading commands from reader
     *
     * @param inputReader to provide commands input
     * @return robot object after execute all the commands.
     */
    static Robot play(Reader inputReader) {
        CommandReader commandReader = new CommandReaderImpl(inputReader);
        Robot robot = new Robot();
        robot.setTableTop(new TableTop(5, 5));

        new RobotController(commandReader).executeCommands(robot);

        return robot;
    }
}
