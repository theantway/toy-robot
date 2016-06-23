package com.rea.robot;

import com.rea.robot.domain.Robot;
import com.rea.robot.domain.TableTop;
import com.rea.robot.reader.CommandReader;
import com.rea.robot.reader.CommandReaderImpl;

import java.io.InputStreamReader;
import java.io.Reader;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to Toy Robot's world, please input commands to control the robot.");
        play(new InputStreamReader(System.in));
    }

    protected static Robot play(Reader inputReader) {
        CommandReader commandReader = new CommandReaderImpl(inputReader);
        Robot robot = new Robot(commandReader);
        robot.setTableTop(new TableTop(5, 5));
        robot.executeCommands();

        return robot;
    }
}
