package com.pp.snake.model;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Snake {

  // tartalmazza a SnakeElement-ek gyűjteméenyét
  private final List<SnakeElement> elements = new LinkedList<>();

  public Snake(SnakeElement... args) {
    elements.addAll(Arrays.asList(args));
  }

  // haladás adott irányban, a pálya méreteit figyelembe véve- visszaadja a fej új koordinátáját
  public Point move(Direction direction, Supplier<Integer> getWidth, Supplier<Integer> getHeight) {
    SnakeElement head = elements.get(0);
    for (int i = elements.size()-1; i > 0; i--) {
      Point prevPoint = elements.get(i-1).getPoint();
      elements.get(i).setPoint(prevPoint.getLocation());
    }
    head.setPoint(direction.getNext(head.getPoint(), getWidth, getHeight));
    return head.getPoint();
  }

  // növekedés adott irányban haladva, a pálya méreteit figyelembe véve - visszaadja a fej új koordinátáját
  public Point grow(Direction direction, Supplier<Integer> getWidth, Supplier<Integer> getHeight) {

    SnakeElement head = elements.get(0);

    SnakeElement newHead = new SnakeElement(head.getPoint().getLocation());
    newHead.setPoint(direction.getNext(newHead.getPoint(), getWidth, getHeight));

    elements.add(0, newHead);

    return newHead.getPoint();
  }

  public Stream<SnakeElement> snakeElements() {
    return elements.stream();
  }
}
