package com.rea.robot.reader;

import com.rea.robot.command.Command;
import com.rea.robot.command.impl.PowerOffCommand;

import java.util.Iterator;

import static java.util.Arrays.asList;

/**
 * A stub CommandReader which return commands specified during construction, and returns one by one.
 *
 * Created by wxu on 6/23/16.
 */
public class CommandReaderStub implements CommandReader {
    private final Iterator<Command> commandsIterator;

    public CommandReaderStub(Command... commands) {
        this.commandsIterator = asList(commands).iterator();
    }

    @Override
    public Command nextCommand() {
        if (commandsIterator.hasNext()) {
            return commandsIterator.next();
        }

        return new PowerOffCommand();
    }
}
