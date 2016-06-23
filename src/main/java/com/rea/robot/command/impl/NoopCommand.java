package com.rea.robot.command.impl;

import com.rea.robot.command.Command;
import com.rea.robot.domain.Robot;

/**
 * This command does nothing, used when received invalid command
 *
 * Created by wxu on 6/23/16.
 */
public class NoopCommand implements Command {
    @Override
    public void execute(Robot robot) {
    }
}
