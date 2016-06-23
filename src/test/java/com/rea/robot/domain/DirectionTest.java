package com.rea.robot.domain;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

@Test
public class DirectionTest {
    public void should_get_left_for_all_directions() {
        Direction[] directions = Direction.values();

        for (Direction direction : Direction.values()) {
            int leftOrdinal = direction.ordinal() - 1;
            if(leftOrdinal < 0) {
                leftOrdinal = directions.length - 1;
            }

            assertThat("left direction of " + direction, direction.left(), is(directions[leftOrdinal]));
        }
    }

    public void should_get_right_for_all_directions() {
        Direction[] directions = Direction.values();

        for (Direction direction : Direction.values()) {
            int rightOrdinal = direction.ordinal() + 1;
            if(rightOrdinal > Direction.values().length - 1){
                rightOrdinal = 0;
            }

            assertThat("right direction of " + direction, direction.right(), is(directions[rightOrdinal]));
        }
    }

    @DataProvider(name = "next_positions")
    public Object[][] nextPositions() {
        return new Object[][] {
                new Object[]{Direction.NORTH, new Position(0, 0), new Position(0, 1)},
                new Object[]{Direction.EAST, new Position(0, 0), new Position(1, 0)},
                new Object[]{Direction.SOUTH, new Position(0, 0), new Position(0, -1)},
                new Object[]{Direction.WEST, new Position(0, 0), new Position(-1, 0)}
        };
    }

    @Test(dataProvider = "next_positions")
    public void should_get_next_position_for_direction(Direction direction, Position current, Position next) {
        assertReflectionEquals(direction.nextPosition(current), next);
    }
}