package com.pp.snake.model;

public class Field {

    // tartalmazza a két dimenziós pálya mlreteit

    private int width;
    private int height;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
