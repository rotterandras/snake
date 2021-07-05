package com.pp.snake.presenter;

import com.pp.snake.model.Direction;
import com.pp.snake.model.Field;
import com.pp.snake.model.Snake;
import com.pp.snake.model.SnakeElement;
import java.awt.Point;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

public class Game {

  private final Field field;
  private final Snake snake;
  private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
  private Runnable refresh;
  private Direction direction = Direction.RIGHT;
  private Direction nextDirection = null;
  private int frame = 0;

  public Game() {
    field = new Field(40, 20);
    snake = new Snake(new SnakeElement(new Point(5, 5)), new SnakeElement(new Point(4, 5)), new SnakeElement(new Point(3, 5)));
  }

  public void start(Runnable refresh) {
    this.refresh = refresh;
    executorService.scheduleAtFixedRate(this::tick, 0, 100, TimeUnit.MILLISECONDS);
  }

  public void setNextDirection(Direction direction) {
    nextDirection = direction;
  }

  private void tick() {
    frame++;
    if(nextDirection != null) {
      direction = nextDirection;
      nextDirection = null;
    }
    Point headPoint = frame % 10 == 0 ? snake.grow(direction, field::getWidth, field::getHeight)
      : snake.move(direction, field::getWidth, field::getHeight);
    refresh.run();
    boolean collide = snake.snakeElements()
      .skip(1)
      .anyMatch(element -> element.getPoint().equals(headPoint));
    if(collide) {
      executorService.shutdown();
      JOptionPane.showMessageDialog(null, "Game Over!");
    }
  }

  public Stream<Point> getSnakePoints() {
    return snake.snakeElements().map(SnakeElement::getPoint);
  }

  public int getFieldHeight() {
    return field.getHeight();
  }

  public int getFieldWidth() {
    return field.getWidth();
  }

}
