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
    elements.forEach(elem -> elem.setPoint(direction.getNext(elem.getPoint(), getWidth.get(), getHeight.get())));
    return elements.get(0).getPoint();
  }
  // növekedés adott irányban haladva, a pálya méreteit figyelembe véve - visszaadja a fej új koordinátáját
  public Point grow(Direction direction, Supplier<Integer> getWidth, Supplier<Integer> getHeight) {

    Point lastPoint = elements.get(elements.size()-1).getPoint();

    Point newPoint = new Point(lastPoint);
    newPoint.setLocation(newPoint.getX()-1, newPoint.getY());

    elements.add(new SnakeElement(newPoint));

    Point head = elements.get(0).getPoint();

    return head;
  }

  public Stream<SnakeElement> snakeElements() {
    return elements.stream();
  }
}
