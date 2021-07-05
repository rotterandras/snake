package com.pp.snake.model;

import java.awt.*;

public class SnakeElement {

  // kígyó egyes elemeinek pozícióját tartalmazaa

    private Point point;

    public SnakeElement(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
