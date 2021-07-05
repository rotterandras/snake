package com.pp.snake.model;

import java.awt.Point;
import java.util.function.Supplier;

public enum Direction {

  // kiszámolja a pálya méreteit figyelembe véve a megfelelő irány szerinti következő koordinátát
  public abstract Point getNext(Point point, Supplier<Integer> getWidth, Supplier<Integer> getHeight);

}
