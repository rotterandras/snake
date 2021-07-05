package com.pp.snake.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.function.Supplier;
import java.util.stream.Stream;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

  private final Color BG = new Color(0, 200, 0);
  private final Color SNAKE = new Color(200, 0, 0);
  private final int SIZE = 15;
  private final Supplier<Stream<Point>> getSnakePoints;
  private final Supplier<Integer> getHeight;
  private final Supplier<Integer> getWidth;

  public GamePanel(Supplier<Stream<Point>> getSnakePoints, Supplier<Integer> getHeight, Supplier<Integer> getWidth) {
    this.getSnakePoints = getSnakePoints;
    this.getHeight = getHeight;
    this.getWidth = getWidth;
    setPreferredSize(new Dimension(getWidth.get() * SIZE, getHeight.get() * SIZE));
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(BG);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(SNAKE);
    getSnakePoints.get().forEach(p -> {
      g.fillOval(p.x * SIZE, p.y * SIZE, SIZE, SIZE);
    });
  }

}
