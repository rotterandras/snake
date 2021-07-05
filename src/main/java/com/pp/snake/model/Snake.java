package com.pp.snake.model;

import java.awt.Point;
import java.util.function.Supplier;

public class Snake {

  // tartalmazza a SnakeElement-ek gyűjteméenyét

  // haladás adott irányban, a pálya méreteit figyelembe véve- visszaadja a fej új koordinátáját
  public Point move(Direction direction, Supplier<Integer> getWidth, Supplier<Integer> getHeight);

  // növekedés adott irányban haladva, a pálya méreteit figyelembe véve - visszaadja a fej új koordinátáját
  public Point grow(Direction direction, Supplier<Integer> getWidth, Supplier<Integer> getHeight);

}
