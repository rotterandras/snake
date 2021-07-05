package com.pp.snake.presenter;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    Game game = new Game();

    @Test
    void getSnakePoints() {
        List<Point> points = game.getSnakePoints().collect(Collectors.toList());
        assertThat(points)
                .hasSize(3)
                .containsExactly(new Point(5,5), new Point(4,5), new Point(3,5));
    }

    @Test
    void getFieldHeight() {
        assertEquals(20, game.getFieldHeight());
    }

    @Test
    void getFieldWidth() {
        assertEquals(40, game.getFieldWidth());
    }
}