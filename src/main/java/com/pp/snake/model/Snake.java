package com.pp.snake.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Snake {

  // tartalmazza a SnakeElement-ek gyűjteméenyét
  private final List<SnakeElement> elements = new ArrayList<>();

  public Snake(SnakeElement... args) {
    Arrays.stream(args).forEach(arg -> elements.add(arg));
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

    SnakeElement newElement = new SnakeElement(head.getPoint().getLocation());
    newElement.setPoint(direction.getNext(newElement.getPoint(), getWidth, getHeight));

    elements.add(0, newElement);

    return newElement.getPoint();
  }

  public Stream<SnakeElement> snakeElements() {
    return elements.stream();
  }
}
