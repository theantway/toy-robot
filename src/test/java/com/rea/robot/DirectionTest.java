package com.rea.robot;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
}