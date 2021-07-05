package com.pp.snake.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class SnakeTest {

    Snake snake;
    List<SnakeElement> elementList;

    SnakeElement first = new SnakeElement(new Point(5, 5));
    SnakeElement second = new SnakeElement(new Point(4, 5));
    SnakeElement third = new SnakeElement(new Point(3, 5));

    @BeforeEach
    void init() {
        snake = new Snake(first, second, third);
    }

    Supplier<Integer> getThirty = () -> 30;

    @ParameterizedTest
    @MethodSource("moveAndGrowArguments")
    void move(Direction direction, Point firstPoint, Point secondPoint, Point thirdPoint) {
        snake.move(direction, getThirty, getThirty);
        elementList = snake.snakeElements().collect(Collectors.toList());
        assertThat(elementList)
                .hasSize(3)
                .extracting(SnakeElement::getPoint)
                .containsExactly(firstPoint, secondPoint, thirdPoint);
    }

    static Stream<Arguments> moveAndGrowArguments() {
        return Stream.of(
                arguments(Direction.RIGHT, new Point(6, 5), new Point(5, 5), new Point(4, 5)),
                arguments(Direction.UP, new Point(5,4), new Point(5,5), new Point(4,5)),
                arguments(Direction.DOWN, new Point(5,6), new Point(5,5), new Point(4,5)),
                // játékban nem valósul meg az ellenkező irányra való szűrés miatt
                arguments(Direction.LEFT, new Point(4,5), new Point(5,5), new Point(4,5))
        );
    }

    @ParameterizedTest
    @MethodSource("moveAndGrowArguments")
    void grow(Direction direction, Point firstPoint, Point secondPoint, Point thirdPoint) {
        snake.grow(direction, getThirty, getThirty);
        elementList = snake.snakeElements().collect(Collectors.toList());
        assertThat(elementList)
                .hasSize(4)
                .extracting(SnakeElement::getPoint)
                .containsExactly(firstPoint, secondPoint, thirdPoint, new Point(3,5));
    }

}