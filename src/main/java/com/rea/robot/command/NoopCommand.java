package com.rea.robot.command;

import com.rea.robot.Robot;

/**
 * This command does nothing, used when received invalid command
 *
 * Created by wxu on 6/23/16.
 */
public class NoopCommand implements Command{
    @Override
    public void execute(Robot robot) {
    }
}
