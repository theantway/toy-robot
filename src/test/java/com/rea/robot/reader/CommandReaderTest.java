package com.rea.robot.reader;

import com.rea.robot.command.impl.*;
import org.testng.annotations.Test;

import java.io.StringReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

@Test
public class CommandReaderTest {
    public void should_read_commands() {
        StringReader reader = new StringReader("PLACE 1,2,NORTH\nLEFT\nRIGHT\nMOVE\nREPORT\n");

        CommandReader commandReader = new CommandReaderImpl(reader);

        assertThat(commandReader.nextCommand(), instanceOf(PlaceCommand.class));
        assertThat(commandReader.nextCommand(), instanceOf(LeftCommand.class));
        assertThat(commandReader.nextCommand(), instanceOf(RightCommand.class));
        assertThat(commandReader.nextCommand(), instanceOf(MoveCommand.class));
        assertThat(commandReader.nextCommand(), instanceOf(ReportCommand.class));
        assertThat(commandReader.nextCommand(), instanceOf(PowerOffCommand.class));
    }

    public void should_handle_invalid_commands() {
        StringReader reader = new StringReader("PLACE\nPLACE 1,2\nPLACE 1,2,NO_DIRECTION\nINVALID");

        CommandReader commandReader = new CommandReaderImpl(reader);

        assertThat(commandReader.nextCommand(), instanceOf(NoopCommand.class));
        assertThat(commandReader.nextCommand(), instanceOf(NoopCommand.class));
        assertThat(commandReader.nextCommand(), instanceOf(NoopCommand.class));
        assertThat(commandReader.nextCommand(), instanceOf(NoopCommand.class));
    }
}