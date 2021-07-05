package com.pp.snake.model;

import java.awt.Point;
import java.util.function.Supplier;

public enum Direction {

  LEFT, RIGHT, UP, DOWN;

  // kiszámolja a pálya méreteit figyelembe véve a megfelelő irány szerinti következő koordinátát
  public Point getNext(Point point, int getWidth, int getHeight) {
    switch (this) {
      case LEFT:
        point.setLocation(point.getX()-1, point.getY());
        break;
      case RIGHT:
        point.setLocation(point.getX()+1, point.getY());
        break;
      case UP:
        point.setLocation(point.getX(), point.getY()+1);
        break;
      case DOWN:
        point.setLocation(point.getX(), point.getY()-1);
        break;
    }
    return point;
  }

}
