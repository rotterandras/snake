package com.pp.snake.model;

import org.graalvm.compiler.nodes.calc.LeftShiftNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @ParameterizedTest
    @MethodSource("oppositeArguments")
    void getOpposite(Direction input, Direction expected) {
        Direction direction = input;
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

    @Test
    void getNext() {
    }
}