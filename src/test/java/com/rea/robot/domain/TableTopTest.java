package com.rea.robot.domain;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TableTopTest {

    @DataProvider(name = "positions")
    public Object[][] positions() {
        return new Object[][]{
                new Object[]{5, 5, 0, 0, true, "left bottom"},
                new Object[]{5, 5, 0, 4, true, "top left "},
                new Object[]{5, 5, 4, 0, true, "right bottom"},
                new Object[]{5, 5, 4, 4, true, "top right"},
                new Object[]{5, 5, -1, 0, false, "out of left"},
                new Object[]{5, 5, 0, 5, false, "out of right"},
                new Object[]{5, 5, 5, 0, false, "out of top"},
                new Object[]{5, 5, 0, -1, false, "out of bottom"},
        };
    }

    @Test(dataProvider = "positions")
    public void should_check_if_position_inside_table_area(int width, int length, int x, int y, boolean expectedResult, String description) {
        boolean result = new TableTop(width, length).isInTableArea(new Position(x, y));

        assertThat(description, result, is(expectedResult));
    }
}