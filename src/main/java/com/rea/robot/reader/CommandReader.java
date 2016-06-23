package com.rea.robot.reader;

import com.rea.robot.command.Command;

/**
 * Read commands
 *
 * Created by wxu on 6/23/16.
 */
public interface CommandReader {
    Command nextCommand();
}
