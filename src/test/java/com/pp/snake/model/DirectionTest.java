package com.pp.snake.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @ParameterizedTest
    @MethodSource("oppositeArguments")
    void getOpposite(Direction input, Direction expected) {
        assertEquals(expected, input.getOpposite());
    }

    static Stream<Arguments> oppositeArguments() {
        return Stream.of(
                Arguments.arguments(Direction.LEFT, Direction.RIGHT),
                Arguments.arguments(Direction.RIGHT, Direction.LEFT),
                Arguments.arguments(Direction.UP, Direction.DOWN),
                Arguments.arguments(Direction.DOWN, Direction.UP)
        );
    }

    @ParameterizedTest
    @MethodSource("getNextArguments")
    void getNext(Direction direction, Point point, Point expected) {
        Point result = direction.getNext(point, getThirty, getThirty);
        assertEquals(expected, result);
    }

    Supplier<Integer> getThirty = () -> 30;


    static Stream<Arguments> getNextArguments() {
        return Stream.of(
                Arguments.arguments(Direction.LEFT, new Point(31, 30), new Point(30, 30)),
                Arguments.arguments(Direction.LEFT, new Point(0, 30), new Point(0, 30)),
                Arguments.arguments(Direction.RIGHT, new Point(10, 10), new Point(11, 10)),
                Arguments.arguments(Direction.RIGHT, new Point(30, 10), new Point(30, 10)),
                Arguments.arguments(Direction.UP, new Point(10, 10), new Point(10, 9)),
                Arguments.arguments(Direction.UP, new Point(10, 0), new Point(10, 0)),
                Arguments.arguments(Direction.DOWN, new Point(10, 10), new Point(10, 11)),
                Arguments.arguments(Direction.DOWN, new Point(10, 30), new Point(10, 30))
        );
    }

}