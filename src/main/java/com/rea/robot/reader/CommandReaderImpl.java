package com.rea.robot.reader;

import com.rea.robot.command.Command;
import com.rea.robot.command.impl.*;
import com.rea.robot.domain.Direction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 * Read commands from Reader, parse string into command objects
 * Created by wxu on 6/23/16.
 */
public class CommandReaderImpl implements CommandReader {
    private static final Logger logger = LoggerFactory.getLogger(CommandReaderImpl.class);

    private final static int NUMBER_OF_PARTS_OF_PLACE_COMMAND = 4;
    private final Command NOOP_COMMAND = new NoopCommand();
    private final Command POWEROFF_COMMAND = new PowerOffCommand();

    private final BufferedReader reader;
    private final Map<String, Command> commands = new HashMap<>();

    public CommandReaderImpl(Reader inputReader) {
        reader = new BufferedReader(inputReader);

        commands.put("MOVE", new MoveCommand());
        commands.put("LEFT", new LeftCommand());
        commands.put("RIGHT", new RightCommand());
        commands.put("REPORT", new ReportCommand());
        commands.put("POWEROFF", POWEROFF_COMMAND);
    }

    /**
     * @return returns command for MOVE, LEFT, RIGHT, REPORT and PLACE in normal case.
     *         returns NoopCommand for invalid command or exception
     *         returns PowerOffCommand when no more data available in reader.
     */
    public Command nextCommand() {
        String commandLine = null;
        try {
            commandLine = reader.readLine();
            if (commandLine == null) {
                return POWEROFF_COMMAND;
            }

            String[] commandParts = commandLine.trim().split(" |,");
            String commandName = commandParts[0].toUpperCase();

            Command command = commands.get(commandName);
            if (command != null) {
                return command;
            }

            if ("PLACE".equals(commandName)) {
                if (commandParts.length != NUMBER_OF_PARTS_OF_PLACE_COMMAND) {
                    return NOOP_COMMAND;
                }

                int x = Integer.parseInt(commandParts[1]);
                int y = Integer.parseInt(commandParts[2]);
                Direction direction = Direction.valueOf(commandParts[3]);

                return new PlaceCommand(x, y, direction);
            } else {
                logger.warn("Invalid command: " + commandLine);

                return NOOP_COMMAND;
            }
        } catch (IOException |IllegalArgumentException e) {
            logger.warn("exception which occurred during read command: " + commandLine);

            return NOOP_COMMAND;
        }
    }
}
