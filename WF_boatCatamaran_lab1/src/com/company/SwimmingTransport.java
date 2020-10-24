package com.company;

import java.awt.*;

abstract class SwimmingTransport implements ITransport{
    protected int startPosX;
    protected int startPosY;
    protected int pictureWidth;
    protected int pictureHeight;
    protected int maxSpeed;
    protected float weight;
    protected Color mainColor;

    public abstract void drawTransport(Graphics g);

    public abstract void moveTransport(Direction direction);

    public void setPosition(int x, int y, int width, int height)
    {
        pictureWidth = width;
        pictureHeight = height;
        startPosX = x;
        startPosY = y;
    }


}
