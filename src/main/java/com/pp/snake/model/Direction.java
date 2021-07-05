package com.pp.snake.model;

import java.awt.Point;
import java.util.function.Supplier;

public enum Direction {

  LEFT, RIGHT, UP, DOWN;

  public Direction getOpposite() {
    switch (this) {
      case LEFT:
        return RIGHT;
      case RIGHT:
        return LEFT;
      case UP:
        return DOWN;
      case DOWN:
        return UP;
      default:
        return this;
    }
  }

  // kiszámolja a pálya méreteit figyelembe véve a megfelelő irány szerinti következő koordinátát
  public Point getNext(Point point, Supplier<Integer> getWidth, Supplier<Integer> getHeight) {
    switch (this) {
      case LEFT:
        moveLeft(point);
        break;
      case RIGHT:
        moveRight(point, getWidth);
        break;
      case UP:
        moveUp(point);
        break;
      case DOWN:
        moveDown(point, getHeight);
        break;
    }
    return point;
  }

  private void moveLeft(Point point) {
    if (point.getX() != 0) {
      point.setLocation(point.getX()-1, point.getY());
    }
  }

  private void moveRight(Point point, Supplier<Integer> getWidth) {
    if (point.getX() != getWidth.get()) {
      point.setLocation(point.getX()+1, point.getY());
    }
  }

  private void moveUp(Point point) {
    if (point.getY() != 0) {
        point.setLocation(point.getX(), point.getY()-1);
    }
  }

  private void moveDown(Point point, Supplier<Integer> getHeight) {
    if (point.getY() != getHeight.get()) {
        point.setLocation(point.getX(), point.getY()+1);
    }
  }

}
